package com.daya.app;

import org.springframework.web.bind.annotation.*;

@RestController
public class DayaWebMicroserviceController {

    @GetMapping("/get")
    public String getData(){
        return "getData";
    }

    @PostMapping("/post")
    public String postData(){
        return "postData";
    }

    @PutMapping("/put")
    public String putData(){
        return "putData";
    }

    @DeleteMapping("/delete")
    public String deleteData(){
        return "deleteData";
    }
}
