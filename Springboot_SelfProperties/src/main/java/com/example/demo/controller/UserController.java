package com.example.demo.controller;

import com.example.demo.common.MyPerson;
import com.example.demo.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Value("${name}")
    private String name;

    @Autowired
    private MyPerson myPersonConfig;

    @Resource
    private User user;

    @RequestMapping("/get")
    public String get() throws Exception{
        System.out.println("address"+myPersonConfig.getAddress());
        System.out.println("--------------------********************--------------------");
        System.out.println("·······················" + user);
        return "name is "+name;
    }
}
