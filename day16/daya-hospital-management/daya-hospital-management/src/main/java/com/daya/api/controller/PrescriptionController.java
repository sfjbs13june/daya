package com.daya.api.controller;

import com.daya.api.model.Prescription;
import com.daya.api.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @GetMapping("/viewprescription")
    public List<Prescription> getAllPrescriptions(String patientName){

        return prescriptionRepository.getByName(patientName);
    }

    @PostMapping("/saveprescription")
    public Prescription savePrescription(@RequestBody Prescription prescription){
        return prescriptionRepository.save(prescription);
    }
}

