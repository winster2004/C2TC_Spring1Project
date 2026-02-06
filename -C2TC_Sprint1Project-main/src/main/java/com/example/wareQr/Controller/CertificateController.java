package com.example.wareQr.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wareQr.model.Certificate;
import com.example.wareQr.serviceee.ICertificateService;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    @Autowired
    private ICertificateService certificateService;

    @PostMapping
    public Certificate addCertificate(@RequestBody Certificate certificate) {
        return certificateService.addCertificate(certificate);
    }

    @GetMapping
    public List<Certificate> getAllCertificates() {
        return certificateService.getAllCertificates();
    }

    @GetMapping("/{id}")
    public Certificate getCertificateById(@PathVariable Long id) {
        return certificateService.getCertificateById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCertificate(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
    }
}