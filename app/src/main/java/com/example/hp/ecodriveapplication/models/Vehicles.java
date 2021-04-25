package com.example.hp.ecodriveapplication.models;

public class Vehicles {
    public String fuelType;
    public String vehicleType;
    public int cc;
    public String vehicleName;
    public String vehicleRegistrationNo;

    public Vehicles(String fuelType, String vehicleType, int cc, String vehicleName, String vehicleRegistrationNo) {
        this.fuelType = fuelType;
        this.vehicleType = vehicleType;
        this.cc = cc;
        this.vehicleName = vehicleName;
        this.vehicleRegistrationNo = vehicleRegistrationNo;
    }



    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleRegistrationNo() {
        return vehicleRegistrationNo;
    }

    public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
        this.vehicleRegistrationNo = vehicleRegistrationNo;
    }
}
