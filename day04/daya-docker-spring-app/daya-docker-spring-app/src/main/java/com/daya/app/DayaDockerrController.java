package com.daya.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DayaDockerrController {

    @GetMapping
    public String getName(){
        return "Dayanidhi";
    }

    @GetMapping
    public String getAge(){
        return "75";
    }

    @GetMapping
    public String getAddr(){
        return "Bangalore";
    }
}
