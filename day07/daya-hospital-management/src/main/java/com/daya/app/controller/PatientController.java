package com.daya.app.controller;


import com.daya.app.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PatientController {
    Map<String, Patient> patientMap= new HashMap<String, Patient>();

    @PostMapping("save/patient")
    public Patient createPatient(@RequestBody Patient patient){
        patientMap.put(patient.getPatient_name(),patient);
        return patient;
    }
    @GetMapping("get/patient")
    public Patient readPatient(@RequestParam("patient_name") String patient_name){
        return patientMap.get(patient_name);
    }

    @PutMapping("update/patient")
    public Patient updatePatient(@RequestParam("patient_name") String patient_name,@RequestParam("hospital_name") String hospital_name){
        Patient patient= patientMap.get(patient_name);
        patient.setHospital_name(hospital_name);
        patientMap.put(patient_name,patient);
        return patient;

    }

    @DeleteMapping("delete/patient")
    public void deletePatient(@RequestParam("patient_name") String patient_name){

        patientMap.remove(patient_name);
    }


}
