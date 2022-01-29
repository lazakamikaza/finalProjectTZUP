package com.elfak.tzup.model;

public class CourseRequest {
    private String courseName;

    public CourseRequest( String courseName) {
        this.courseName = courseName;
    }

    public CourseRequest() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
