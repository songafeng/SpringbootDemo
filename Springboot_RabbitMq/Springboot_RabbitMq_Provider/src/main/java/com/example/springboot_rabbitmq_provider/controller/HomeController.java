package com.example.springboot_rabbitmq_provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("hello")
    public String Hello(){
        return "ok";
    }
}
