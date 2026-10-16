package model;

import java.time.LocalDateTime;

public class Enrollment {
    private int id;
    private int studentId;
    private String courseCode;
    private LocalDateTime enrolledAt;
    private EnrollmentStatus status = EnrollmentStatus.ACTIVE;

    public Enrollment() {
    }

    public Enrollment(int studentId, String courseCode,
                      LocalDateTime enrolledAt, EnrollmentStatus status) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.enrolledAt = enrolledAt;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }
}
