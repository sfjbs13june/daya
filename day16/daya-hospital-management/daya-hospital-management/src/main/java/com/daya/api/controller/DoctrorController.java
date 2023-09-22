package com.daya.api.controller;

import com.daya.api.model.Appontment;
import com.daya.api.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctrorController {

    @Autowired
    public final AppointmentRepository appointmentRepository;

    @Autowired
    public DoctrorController(AppointmentRepository appointmentRepository){
        this.appointmentRepository=appointmentRepository;
    }

    @GetMapping("/doctorappointment")
    public List<Appontment> getAppointments(@RequestParam String doctorName){
        return appointmentRepository.getByName(doctorName);
    }
    @PostMapping("/save")
    public Appontment saveAppointment(@RequestBody Appontment appointment){
        return appointmentRepository.save(appointment);
    }
}
