package com.daya.app.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/getstudent")

    public String getStudentDetail(){
        return "student1";
    }

    @PutMapping("/updatestudent")

    public String updatestudentDetail(){
        return "Updated student1";
    }

    @DeleteMapping("/deletestudent")

    public String deletestudentDetail(){
        return "deleted student1";
    }
}
