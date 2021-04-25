package com.example.hp.ecodriveapplication.models;

import android.net.Uri;

import com.google.firebase.firestore.GeoPoint;

import java.util.List;

public class User {
    public String uid;
    public GeoPoint geoPoint;
    public String name;
    public String emailId;
    public String password;
    public Uri imageUri;
    public String nickName;
    public String gender;
    public String phoneNo;
    public List<Vehicles> vehiclesList;


    public List<Vehicles> getVehiclesList() {
        return vehiclesList;
    }

    public void setVehiclesList(List<Vehicles> vehiclesList) {
        this.vehiclesList = vehiclesList;
    }


    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImageUri(Uri imageUri) {
        imageUri = imageUri;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }
}

