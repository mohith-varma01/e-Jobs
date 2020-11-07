package com.example.e_jobs.Modal;

import android.net.Uri;

public class Course
{
    String courseId;
    private String courseName;
    private Uri courseVideoUri;
    private Uri courseImageUri;

    public Course() {
    }

    public Course(String courseId, String courseName, Uri courseVideoUri, Uri courseImageUri) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseVideoUri = courseVideoUri;
        this.courseImageUri = courseImageUri;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Uri getCourseVideoUri() {
        return courseVideoUri;
    }

    public void setCourseVideoUri(Uri courseVideoUri) {
        this.courseVideoUri = courseVideoUri;
    }

    public Uri getCourseImageUri() {
        return courseImageUri;
    }

    public void setCourseImageUri(Uri courseImageUri) {
        this.courseImageUri = courseImageUri;
    }
}