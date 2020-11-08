package com.example.e_jobs.Modal;

import android.net.Uri;

import java.io.StringReader;

public class Course
{
    private int courseId;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    private String courseName;
    private String  courseVideoUri;
    private String courseImageUri;
    private String courseField;

    public String getCourseField() {
        return courseField;
    }

    public void setCourseField(String courseField) {
        this.courseField = courseField;
    }

    public Course() {
    }

//    public Course(String courseName, String  courseVideoUri, String  courseImageUri, String courseField) {
//
//        this.courseName = courseName;
//        this.courseVideoUri = courseVideoUri;
//        this.courseImageUri = courseImageUri;
//        this.courseField = courseField;
//    }

    public Course(int id, String courseName, int courseId, String courseField)
    {
        this.courseField = courseField;
        this.courseId = courseId;
        this.courseName = courseName;
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getId() { return id;}

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String  getCourseVideoUri() {
        return courseVideoUri;
    }

    public void setCourseVideoUri(String  courseVideoUri) {
        this.courseVideoUri = courseVideoUri;
    }

    public String  getCourseImageUri() {
        return courseImageUri;
    }

    public void setCourseImageUri(String courseImageUri) {
        this.courseImageUri = courseImageUri;
    }
}
