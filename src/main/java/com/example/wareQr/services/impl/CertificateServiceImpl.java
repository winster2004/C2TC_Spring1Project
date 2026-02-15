package com.example.wareQr.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wareQr.model.Certificate;
import com.example.wareQr.repository.CertificateRepository;
import com.example.wareQr.serviceee.ICertificateService;

@Service
public class CertificateServiceImpl implements ICertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Override
    public Certificate addCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    @Override
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    @Override
    public Certificate getCertificateById(Long id) {
        Optional<Certificate> certificate = certificateRepository.findById(id);
        return certificate.orElse(null);
    }

    // ✅ NEW METHOD - UPDATE CERTIFICATE
    @Override
    public Certificate updateCertificate(Long id, Certificate certificateDetails) {
        // First, check if certificate exists
        Optional<Certificate> existingCertificateOpt = certificateRepository.findById(id);
        
        if (existingCertificateOpt.isPresent()) {
            // Certificate exists, update it
            Certificate existingCertificate = existingCertificateOpt.get();
            
            // Update certificate fields
            existingCertificate.setCertificateName(certificateDetails.getCertificateName());
            existingCertificate.setIssueDate(certificateDetails.getIssueDate());
            
            // Update student relationship if provided
            if (certificateDetails.getStudent() != null) {
                existingCertificate.setStudent(certificateDetails.getStudent());
            }
            
            // Save and return updated certificate
            return certificateRepository.save(existingCertificate);
        }
        
        // Certificate not found, return null
        return null;
    }

    @Override
    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }
}