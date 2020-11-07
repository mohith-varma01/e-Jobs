package com.example.e_jobs.Modal;

import android.net.Uri;

import java.net.URI;

public class User {
    private String userFirstName;
    private String userLastName;
    private String userMailAddress;
    private int userPhoneNumber;
    private Uri userProfileUrl;
    private int userRank;
    private String userAboutDetails;

    public User() {
    }

    public User(String userFirstName, String userLastName, String userMailAddress, int userPhoneNumber, Uri userProfileUrl, int userRank, String userAboutDetails) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userMailAddress = userMailAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userProfileUrl = userProfileUrl;
        this.userRank = userRank;
        this.userAboutDetails = userAboutDetails;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserMailAddress() {
        return userMailAddress;
    }

    public void setUserMailAddress(String userMailAddress) {
        this.userMailAddress = userMailAddress;
    }

    public int getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(int userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Uri getUserProfileUrl() {
        return userProfileUrl;
    }

    public void setUserProfileUrl(Uri userProfileUrl) {
        this.userProfileUrl = userProfileUrl;
    }

    public int getUserRank() {
        return userRank;
    }

    public void setUserRank(int userRank) {
        this.userRank = userRank;
    }

    public String getUserAboutDetails() {
        return userAboutDetails;
    }

    public void setUserAboutDetails(String userAboutDetails) {
        this.userAboutDetails = userAboutDetails;
    }
}

