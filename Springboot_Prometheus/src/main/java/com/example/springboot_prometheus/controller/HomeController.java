package com.example.springboot_prometheus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = "/show")
    public String Show()
    {
        return "I love you,world!";
    }
}
