package main.backend.elearning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.backend.elearning.dto.CertificationDTO;

import main.backend.elearning.repository.CertificationRepository;


@Service
public class CertificationService {
     // Autowiring CertificationRepository for data access
  @Autowired
  private CertificationRepository certificationRepository;

  // Method to retrieve all certifications
  public List<CertificationDTO> getAllCertification() {
    return certificationRepository.findAll();
  }

  // Method to retrieve a certification by its ID
  public CertificationDTO getCertificationId(Long certificateId) {
    return certificationRepository.findById(certificateId).orElse(null);
  }

  // Method to retrieve certifications for a specific user
  public Optional<CertificationDTO> getCertificationByUserId(Long userId) {
    return certificationRepository.findById(userId);
  }

  // Method to save a new certification
  public CertificationDTO savCertification(CertificationDTO certificationDTO) {
    return certificationRepository.save(certificationDTO);
  }

  // Method to delete a certification by its ID
  public void deleteCertification(Long certificateId) {
    certificationRepository.deleteById(certificateId);
  }

 /* public CertificationDTO getMostRecentCertificationForUser(Long userId) {
    return certificationRepository.findMostRecentCertificateByUser(userId);
  }*/ 
}
