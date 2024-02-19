package main.backend.elearning.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Date;

@Entity
public class Certification {

   // Primary Key
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long certificateId;

   // File path or identifier for the certificate file
   private String certificateFile;

   // Criteria or details associated with the certification
   private String criteria;

   // Unique serial number for the certification
   private String serialNo;

   // Date when the certification was issued
   private Date dateIssued;

   // Time when the certification was issued
   @Column(name = "time_issued")
   private String timeIssued;

   /* Many-to-One relationship with FinalScore entity
   @ManyToOne
   @JoinColumn(name = "final_score_id")
   private FinalScore finalScore; */

   public Long getCertificateId() {
       return this.certificateId;
   }

   public void setCertificateId(Long certificateId) {
       this.certificateId = certificateId;
   }

   public String getCertificateFile() {
       return this.certificateFile;
   }

   public void setCertificateFile(String certificateFile) {
       this.certificateFile = certificateFile;
   }

   public String getCriteria() {
       return this.criteria;
   }

   public void setCriteria(String criteria) {
       this.criteria = criteria;
   }

   public String getSerialNo() {
       return this.serialNo;
   }

   public void setSerialNo(String serialNo) {
       this.serialNo = serialNo;
   }

   public Date getDateIssued() {
       return this.dateIssued;
   }

   public void setDateIssued(Date dateIssued) {
       this.dateIssued = dateIssued;
   }

   public String getTimeIssued() {
       return this.timeIssued;
   }

   public void setTimeIssued(String timeIssued) {
       this.timeIssued = timeIssued;
   }
}
