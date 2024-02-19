package main.backend.elearning.controller;

// REST controller for Certification entity

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.criteria.Path;
import main.backend.elearning.dto.CertificationDTO;
import main.backend.elearning.service.CertificationService;

@RestController
@RequestMapping("/api/certifications")
@CrossOrigin("http://localhost:5173/")
public class CertificationController {

  // Autowired annotation to inject CertificationService dependency
  @Autowired
  private CertificationService certificationService;

  // Autowired annotation to inject QuizTakenService dependency
 // @Autowired
// private QuizTakenService quizTakenService; // Assuming you have QuizTakenService to retrieve QuizTaken

  // Endpoint to retrieve all certifications
  @GetMapping
  public List<CertificationDTO> getAllCertification() {
    return certificationService.getAllCertification();
  }

  // Endpoint to retrieve a certification by its ID
  @GetMapping("/{certificateId}")
  public CertificationDTO getCertificationById(@PathVariable Long certificateId) {
    return certificationService.getCertificationId(certificateId);
  }

  // Endpoint to retrieve certifications for a specific user
  @GetMapping("/myCertification/{user_ID}")
  public Optional<CertificationDTO> getCertificationByUserId(
      @PathVariable Long userId) {
    return certificationService.getCertificationByUserId(userId);
  }

  // Endpoint to save a new certification
  @PostMapping
  public ResponseEntity<String> saveCertification(
      @RequestParam("certificate_file") MultipartFile certificateFile,
      @RequestParam("criteria") String criteria,
      @RequestParam("serial_no") String serialNo,
      @RequestParam("date_issued") Date dateIssued,
      @RequestParam("time_issued") String timeIssued)
     // @RequestParam("quiztkn_ID") Long quiztkn_ID) 
     {
    if (certificateFile.isEmpty()) {
      return ResponseEntity.badRequest().body("File is empty");
    }

    try {
      // Save the certificate file to a specific path
      byte[] bytes = certificateFile.getBytes();
      String originalFilename = certificateFile.getOriginalFilename();
      String filenameWithoutPrefix = originalFilename.startsWith("PDF")
          ? originalFilename.substring(3)
          : originalFilename;
     /*     
      Path path = Paths.get(
          "C:\\Users\\vsbu\\Desktop\\CMSPROJECT_V.2\\cmsproject_v.2\\public\\PDF\\" +
              filenameWithoutPrefix);
      Files.write(path, bytes); */ 

      /*  Retrieve the associated QuizTaken entity
      QuizTaken quizTaken = quizTakenService.getQuizTakenId(quiztkn_ID);
      if (quizTaken == null) {
        return ResponseEntity
            .badRequest()
            .body("QuizTaken not found with ID: " + quiztkn_ID);
      }*/

      // Create a new Certification entity and set its properties
      CertificationDTO certificationDTO = new CertificationDTO();
      certificationDTO.setSerialNo(serialNo);
      certificationDTO.setDateIssued(dateIssued);
      certificationDTO.setTimeIssued(timeIssued);
      certificationDTO.setCertificateFile(filenameWithoutPrefix);
      certificationDTO.setCriteria(criteria);
     // certificationDTO.setQuizTaken(quizTaken); // Set QuizTaken in Certification
      certificationService.savCertification(certificationDTO);

      return ResponseEntity.ok("Certificate saved successfully");
    } catch (IOException e) {
      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Failed to save certificate: " + e.getMessage());
    }
  }

  // Endpoint to delete a certification by its ID
  @DeleteMapping("/{certificateId}")
  public void deleteCertification(@PathVariable Long certificateId) {
    certificationService.deleteCertification(certificateId);
  }

  // Endpoint to retrieve the most recent certificate for a specific user
 /*  @GetMapping("/myRecentCertification/{user_ID}")
  public CertificationDTO getMostRecentCertificationForUser(@PathVariable Long userId) {
    return certificationService.getMostRecentCertificationForUser(userId);
  } */

}