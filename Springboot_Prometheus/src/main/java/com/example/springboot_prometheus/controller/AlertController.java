package com.example.springboot_prometheus.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertController {

    @PostMapping("/toAlert")
    public void toAlert(@RequestBody String body){
        System.out.println("this is toAlert");
        System.out.println("body:"+body);

    }
}
