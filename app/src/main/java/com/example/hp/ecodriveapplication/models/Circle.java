package com.example.hp.ecodriveapplication.models;

import java.util.ArrayList;

public class Circle {

    String circleId;
    String circleName;
    int memberCount;
    String cityName;
    ArrayList<String> userIdList;

    public Circle(){
        userIdList = new ArrayList<>();
        memberCount=0;
    }

    public String getCircleId() {
        return circleId;
    }

    public void setCircleId(String circleId) {
        this.circleId = circleId;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public ArrayList<String> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(ArrayList<String> useridList) {
        this.userIdList = useridList;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
