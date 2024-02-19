package main.backend.elearning.dto;

public class CertificateVerificationResponse {

  // Title of the course associated with the verification response
  private String courseTitle;

  // Serial number used for verification
  private String serialNo;

  private String firstName;

  private String lastName;

  // Default constructor for the VerificationResponse DTO
  public CertificateVerificationResponse(
    String serialNo,
    String courseTitle,
    String firstName,
    String lastName
  ) {
    this.courseTitle = courseTitle;
    this.serialNo = serialNo;
    this.firstName = firstName;
    this.lastName = lastName;
  }


    public String getCourseTitle() {
        return this.courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getSerialNo() {
        return this.serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
