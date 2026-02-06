package com.example.wareQr.serviceee;

import java.util.List;

import com.example.wareQr.model.Certificate;

public interface ICertificateService {

    Certificate addCertificate(Certificate certificate);

    List<Certificate> getAllCertificates();

    Certificate getCertificateById(Long id);

    void deleteCertificate(Long id);
}