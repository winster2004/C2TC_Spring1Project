package com.example.wareQr.services.impl;

import java.util.List;

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
        return certificateRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }
}