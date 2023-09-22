package com.daya.api.controller;

import com.daya.api.model.Appontment;
import com.daya.api.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @GetMapping("/myappointment")
    public List<Appontment> getMyAppointments(@RequestParam String patientName){

        return appointmentRepository.getByName(patientName);
    }

    @PostMapping("/save")
    public Appontment saveAppointment(@RequestBody Appontment appointment){
        return appointmentRepository.save(appointment);
    }


}

