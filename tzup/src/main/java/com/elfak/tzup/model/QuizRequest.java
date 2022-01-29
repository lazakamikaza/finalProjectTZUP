package com.elfak.tzup.model;

public class QuizRequest {
    private String courseName;
    private int studentIndex;
    private String studentFirstname;
    private String studentLastname;
    private int quizId;
    private String timeCreated;

    public QuizRequest(String courseName, int studentIndex, String studentFirstname, String studentLastname, int quizId, String timeCreated) {
        this.courseName = courseName;
        this.studentIndex = studentIndex;
        this.studentFirstname = studentFirstname;
        this.studentLastname = studentLastname;
        this.quizId = quizId;
        this.timeCreated = timeCreated;
    }

    public QuizRequest() {
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
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

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }
}
