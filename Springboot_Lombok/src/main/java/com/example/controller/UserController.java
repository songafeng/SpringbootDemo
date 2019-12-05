package com.example.controller;

import com.example.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jdd on 2019/12/5.
 */
@RestController
@Slf4j
public class UserController {

    @RequestMapping("hello")
    public String Hello(){
        log.debug("debug message");
        log.warn("warn message");
        log.info("info message");
        log.error("error message");
        log.trace("trace message");
        return "ok";
    }

    @RequestMapping("getuser")
    public User getUser(){
        User user=new User();
        user.setId(1000);
        user.setUserName("afeng");
        user.setRealName("宋贵生");
        user.setPassWord("111111");
        return user;
    }
}
