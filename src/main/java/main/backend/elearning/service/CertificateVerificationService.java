package main.backend.elearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.backend.elearning.dto.CertificateVerificationResponse;
import main.backend.elearning.repository.CertificateVerificationRepository;

@Service
public class CertificateVerificationService {
      // Autowiring VerificationRepository for data access
  @Autowired
  private CertificateVerificationRepository verificationRepository;

  // Method to retrieve verification details by serial number
  public List<CertificateVerificationResponse> getCertificationDetailsBySerialNumber(
    String serialNo
  ) {
    return verificationRepository.findBySerialNumberWithDetails(serialNo);
  }
}
