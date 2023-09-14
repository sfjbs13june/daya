package com.daya.app.controller;

import com.daya.app.model.HospitalMongo;
import com.daya.app.repository.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/hospital")
public class HospitalMongoController {
    @Autowired
    Hospital hospital;

//    public List<Hospital> findAll() {
//        List<Hospital> hospitals = new ArrayList<>();
//        hospitalRepository.findAll().forEach(hospitals::add);
//        return hospitals;
//    }

    @PostMapping(value = "/savehospital")
    public @ResponseBody String store(@RequestBody final HospitalMongo hospitalmongo) {
        hospital.save(hospitalmongo);
        return "Hospital Saved";
    }

    @GetMapping(value = "/hospitalrecords")
    public @ResponseBody Iterable<HospitalMongo> getAll() {
        return hospital.findAll();
    }

    @PutMapping(value = "/edithospital")
    public @ResponseBody String store(@RequestParam("name") String name,@RequestParam("address") String address) {
        List<HospitalMongo> list = hospital.findAll();
        if(list.size()<1) return "Hospital Records are Empty";
        for (HospitalMongo hp: list){
            if(hp.getHospitalName().equals(name)) {
                hp.setAddress(address);
                hospital.save(hp);
                return "Hospital " + hp.getHospitalName() + " Updated";
            }
        }
        return "Hospital Not Found";
    }

    @DeleteMapping(value = "/deletehospital")
    public @ResponseBody
    String store(@RequestParam("name") final String name) {
        List<HospitalMongo> list = hospital.findAll();
        if(list.size()<1) return "Hospital Records are Empty";
        for (HospitalMongo hp: list){
            if(hp.getHospitalName().equals(name)) {
                hospital.delete(hp);
                return "Hospital " + hp.getHospitalName() + " Deleted";
            }
        }
        return "Hospital Not found";
    }


}
