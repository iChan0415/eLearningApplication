package main.backend.elearning.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import main.backend.elearning.dto.CertificationDTO;

// JPA repository interface for Certification entity with Long as the primary key type
public interface CertificationRepository
    extends JpaRepository<CertificationDTO, Long> {
  // Method to retrieve all certifications
  List<CertificationDTO> findAll();
  // Method to retrieve a certification by its ID
  Optional<CertificationDTO> findById(Long certificateId);

  /* Custom query to retrieve certifications based on user ID
  @Query("SELECT cr FROM CertificationDTO cr WHERE cr.quizTaken.users.userID = :user_ID")
  List<CertificationDTO> findByUserId(@Param("user_ID") Long user_ID);

  @Query(value = "SELECT * FROM certificationDTO cr WHERE cr.quiztkn_id IN " +
      "(SELECT qt.quiztknID FROM quiz_taken qt WHERE qt.user_ID = :user_ID) " +
      "ORDER BY cr.date_issued DESC, cr.time_issued DESC LIMIT 5", nativeQuery = true)
      CertificationDTO findMostRecentCertificateByUser(@Param("user_ID") Long userID); */ 
}
