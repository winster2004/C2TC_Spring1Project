package com.example.wareQr.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wareQr.model.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}