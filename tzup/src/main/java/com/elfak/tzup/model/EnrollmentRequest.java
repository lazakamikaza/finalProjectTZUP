package com.elfak.tzup.model;


public class EnrollmentRequest {
    String courseName;
    int studentIndex;
    String studentFirstname;
    String studentLastname;
    String studentEmail;

    public EnrollmentRequest() {
    }

    public EnrollmentRequest(String courseName, int studentIndex, String studentFirstname, String studentLastname, String studentEmail) {
        this.courseName = courseName;
        this.studentIndex = studentIndex;
        this.studentFirstname = studentFirstname;
        this.studentLastname = studentLastname;
        this.studentEmail = studentEmail;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getStudentIndex() {
        return studentIndex;
    }

    public void setStudentIndex(int studentIndex) {
        this.studentIndex = studentIndex;
    }

    public String getStudentFirstname() {
        return studentFirstname;
    }

    public void setStudentFirstname(String studentFirstname) {
        this.studentFirstname = studentFirstname;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public void setStudentLastname(String studentLastname) {
        this.studentLastname = studentLastname;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
}

