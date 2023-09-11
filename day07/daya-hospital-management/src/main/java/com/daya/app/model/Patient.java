package com.daya.app.model;

import org.springframework.stereotype.Component;

@Component
public class Patient {
    String patient_name;
    String  patient_id;
    String hospital_name;
    String disease;

    public Patient() {}

    public Patient(String patient_name, String patient_id, String hospital_name, String disease) {
        this.patient_name = patient_name;
        this.patient_id = patient_id;
        this.hospital_name = hospital_name;
        this.disease = disease;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
