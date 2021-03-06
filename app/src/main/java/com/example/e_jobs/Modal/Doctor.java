package com.example.e_jobs.Modal;

import android.net.Uri;

public class Doctor
{
    private String DocId;
    private String DoctorName;
    private String DoctorCredentials;
    private String  DoctorProfileUri;

    public Doctor() {
    }

    public Doctor( String docId, String doctorName, String doctorCredentials, String  doctorProfileUri) {
        this.DocId = docId;
        DoctorName = doctorName;
        DoctorCredentials = doctorCredentials;
        DoctorProfileUri = doctorProfileUri;
    }

    public String getDocId() {
        return DocId;
    }

    public void setDocId(String docId) {
        DocId = docId;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getDoctorCredentials() {
        return DoctorCredentials;
    }

    public void setDoctorCredentials(String doctorCredentials) {
        DoctorCredentials = doctorCredentials;
    }

    public String getDoctorProfileUri() {
        return DoctorProfileUri;
    }

    public void setDoctorProfileUri(String doctorProfileUri) {
        DoctorProfileUri = doctorProfileUri;
    }
}
