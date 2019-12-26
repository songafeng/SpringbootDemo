package com.example.controller;

import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jdd on 2019/12/26.
 */
@RestController
public class HomeController {

    @Autowired
    private User user;

    @RequestMapping("/")
    public String index() {

        String url=user.getUrl();

        return "hello "+ url;
    }
}
