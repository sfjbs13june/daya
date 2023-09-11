package com.daya.app.controller;

import com.daya.app.model.Hospital;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;



@RestController
public class HospitalController {

    Map<String, Hospital> hospitalMap= new HashMap<String, Hospital>();

    @PostMapping("save/hospital")
    public Hospital createHospital(@RequestBody Hospital hospital){
        hospitalMap.put(hospital.getHospital_name(),hospital);
        return hospital;
    }
    @GetMapping("get/hospital")
    public Hospital readHospital(@RequestParam("hospital_name") String hospital_name){
        return hospitalMap.get(hospital_name);
    }

    @PutMapping("update/hospital")
    public Hospital updateHospital(@RequestParam("hospital_name") String hospital_name,@RequestParam("address") String address){
        Hospital hospital= hospitalMap.get(hospital_name);
        hospital.setAddress(address);
        hospitalMap.put(hospital_name,hospital);
        return hospital;
    }

    @DeleteMapping("delete/hospital")
    public void deleteHospital(@RequestParam("hospital_name") String hospital_name){
        hospitalMap.remove(hospital_name);
    }
}
