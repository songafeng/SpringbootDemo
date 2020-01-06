package com.example.controller;

import com.example.client.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping(value = "/echo/{str}")
    public String echo(@PathVariable String str) {

        return testService.echo(str);
    }
}