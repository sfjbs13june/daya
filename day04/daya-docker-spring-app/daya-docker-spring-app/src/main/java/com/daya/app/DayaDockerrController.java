package com.daya.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DayaDockerrController {

    @GetMapping
    public String getName(){
        return "Dayanidhi";
    }
}
