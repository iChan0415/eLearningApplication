package main.backend.elearning.repository;

import java.util.List;
import main.backend.elearning.dto.CertificateVerificationResponse;
import main.backend.elearning.dto.CertificationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CertificateVerificationRepository
  extends JpaRepository<CertificationDTO, Long> {
  // Custom query to retrieve verification details based on serial number
  @Query(
    "SELECT new main.backend.elearning.dto.CertificateVerificationResponse(cr.serial_no, cr.finalscore.quiz.chapter.course.title, cr.finalscore.student.first_name, cr.finalscore.student.last_name) FROM Certification cr WHERE cr.serial_no = :serial_no"
  )
  List<CertificateVerificationResponse> findBySerialNumberWithDetails(
    @Param("serial_no") String serialNo
  );
}
