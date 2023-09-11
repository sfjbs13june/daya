package com.daya.app.model;

import org.springframework.stereotype.Component;


@Component
public class Hospital {
    String hospital_name;
    String address;
    String id;

    public Hospital() {}

    public Hospital(String hospital_name, String address, String id) {
        this.hospital_name = hospital_name;
        this.address = address;
        this.id = id;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospitalName(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
