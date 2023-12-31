package com.daya.api.model;

import org.springframework.data.annotation.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Prescription {
    @Id
    @GeneratedValue
    @Column(name = "prescriptionId")
    private String prescriptionId;
    @Column(name = "appointmentId")
    private String appointmentId;
    @Column(name = "description")
    private String description;
    @Column(name = "patientName")
    private String patientName;
    @Column(name = "doctorName")
    private String doctorName;
    public Prescription() {
    }
    public Prescription(String prescriptionId, String appointmentId, String description, String patientName, String doctorName) {
        this.prescriptionId = prescriptionId;
        this.appointmentId = appointmentId;
        this.description = description;
        this.patientName = patientName;
        this.doctorName = doctorName;
    }


    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
