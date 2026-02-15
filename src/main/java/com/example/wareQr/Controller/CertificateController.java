package com.example.wareQr.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.wareQr.model.Certificate;
import com.example.wareQr.model.Student;
import com.example.wareQr.serviceee.ICertificateService;

@RestController
@RequestMapping("/certificates")
@CrossOrigin(origins = "http://localhost:4200")
public class CertificateController {

    @Autowired
    private ICertificateService certificateService;

    // ✅ EXISTING JSON CREATE (UNCHANGED)
    @PostMapping
    public ResponseEntity<Certificate> addCertificate(@RequestBody Certificate certificate) {
        try {
            Certificate savedCertificate = certificateService.addCertificate(certificate);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCertificate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // ✅ NEW FILE UPLOAD CREATE (SAFE ADDITION)
    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<Certificate> addCertificateWithImage(
            @RequestParam("certificateName") String certificateName,
            @RequestParam("issueDate") String issueDate,
            @RequestParam("studentId") Long studentId,
            @RequestParam("image") MultipartFile file) {

        try {

            String uploadDir = "uploads/";
            File uploadFolder = new File(uploadDir);
            if (!uploadFolder.exists()) {
                uploadFolder.mkdir();
            }

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);

            Files.write(filePath, file.getBytes());

            Certificate certificate = new Certificate();
            certificate.setCertificateName(certificateName);
            certificate.setIssueDate(LocalDate.parse(issueDate));
            certificate.setImagePath(fileName);

            Student student = new Student();
            student.setStudentId(studentId);
            certificate.setStudent(student);

            Certificate saved = certificateService.addCertificate(certificate);

            return ResponseEntity.status(HttpStatus.CREATED).body(saved);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Certificate>> getAllCertificates() {
        try {
            List<Certificate> certificates = certificateService.getAllCertificates();
            if (certificates.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(certificates);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Certificate> getCertificateById(@PathVariable Long id) {
        try {
            Certificate certificate = certificateService.getCertificateById(id);
            if (certificate != null) {
                return ResponseEntity.ok(certificate);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // ✅ IMAGE VIEW ENDPOINT
    @GetMapping("/image/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) {
        try {
            Path path = Paths.get("uploads/" + filename);
            byte[] image = Files.readAllBytes(path);

            return ResponseEntity
                    .ok()
                    .header("Content-Type", Files.probeContentType(path))
                    .body(image);

        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Certificate> updateCertificate(
            @PathVariable Long id,
            @RequestBody Certificate certificate) {
        try {
            Certificate updatedCertificate = certificateService.updateCertificate(id, certificate);
            if (updatedCertificate != null) {
                return ResponseEntity.ok(updatedCertificate);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertificate(@PathVariable Long id) {
        try {
            certificateService.deleteCertificate(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
