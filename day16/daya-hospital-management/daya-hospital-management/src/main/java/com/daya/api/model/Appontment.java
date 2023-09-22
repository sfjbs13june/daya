package com.daya.api.model;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Appontment {

    @Id
    @GeneratedValue
    @Column(name = "appointmentId")
    String appointmentId;
    @Column(name = "patientName")
    String patientName;
    @Column(name = "doctorName")
    String doctorName;
    @Column(name = "date")
    String date;
    @Column(name = "prescription")
    Prescription prescription;

    public Appontment() {
    }

    public Appontment(String appointmentId, String patientName, String doctorName, String date, Prescription prescription) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.prescription = prescription;
    }


    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }



}
