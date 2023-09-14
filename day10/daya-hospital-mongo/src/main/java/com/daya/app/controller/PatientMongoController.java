package com.daya.app.controller;

import com.daya.app.model.PatientMongo;
import com.daya.app.repository.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/patient")
public class PatientMongoController {
    @Autowired
    Patient patientRepository;


    @PostMapping(value = "/savepatient")
    public @ResponseBody String store(@RequestBody final PatientMongo patient) {
        patientRepository.save(patient);
        return "Patient Saved";
    }

    @GetMapping(value = "/patientrecords")
    public @ResponseBody Iterable<PatientMongo> getAll() {
        return patientRepository.findAll();
    }

    @PutMapping(value = "/editpatient")
    public @ResponseBody String store(@RequestParam("name") String name,@RequestParam("hospital") String hospital) {
        List<PatientMongo> list = patientRepository.findAll();
        if(list.size()<1) return "Patient Records are Empty";
        for (PatientMongo hp: list){
            if(hp.getPatientName().equals(name)) {
                hp.setHospitalName(hospital);
                patientRepository.save(hp);
                return "Patient " + hp.getPatientName() + " Updated";
            }
        }
        return "Patient Not Found";
    }

    @DeleteMapping(value = "/deletepatient")
    public @ResponseBody
    String store(@RequestParam("name") final String name) {
        List<PatientMongo> list = patientRepository.findAll();
        if(list.size()<1) return "Patient Records are Empty";
        for (PatientMongo hp: list){
            if(hp.getPatientName().equals(name)) {
                patientRepository.delete(hp);
                return "Patient " + hp.getPatientName() + " Deleted";
            }
        }
        return "Patient Not found";
    }

}
