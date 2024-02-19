package main.backend.elearning.dto;

import java.sql.Date;

public class CertificateDetailsResponse {

    private Long studentId;
    private String studentFirstName;
    private String studentLastName;
    private Long courseId;
    private String courseTitle;
    private Date enrollmentDate;
    private String instructorFirstName;
    private String instructorLastName;
    private Long finalScoreId;
    private Long averageId;

    public Long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return this.studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return this.studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public Long getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return this.courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Date getEnrollmentDate() {
        return this.enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getInstructorFirstName() {
        return this.instructorFirstName;
    }

    public void setInstructorFirstName(String instructorFirstName) {
        this.instructorFirstName = instructorFirstName;
    }

    public String getInstructorLastName() {
        return this.instructorLastName;
    }

    public void setInstructorLastName(String instructorLastName) {
        this.instructorLastName = instructorLastName;
    }

    public Long getFinalScoreId() {
        return this.finalScoreId;
    }

    public void setFinalScoreId(Long finalScoreId) {
        this.finalScoreId = finalScoreId;
    }

    public Long getAverageId() {
        return this.averageId;
    }

    public void setAverageId(Long averageId) {
        this.averageId = averageId;
    }

    public CertificateDetailsResponse(
            Long studentId,
            String studentFirstName,
            String studentLastName,
            Long courseId,
            String courseTitle,
            Date enrollmentDate,
            String instructorFirstName,
            String instructorLastName,
            Long finalScoreId,
            Long averageId
    ) {
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.enrollmentDate = enrollmentDate;
        this.instructorFirstName = instructorFirstName;
        this.instructorLastName = instructorLastName;
        this.finalScoreId = finalScoreId;
        this.averageId = averageId;
    }
}
