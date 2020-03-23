package com.example.springboot_quartz.controller;

import com.example.springboot_quartz.MyJob.TimerStudy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private TimerStudy timerStudy;

    @RequestMapping("/get")
    public String redis() throws Exception{
        timerStudy.Start();
        return "ok";
    }

//    @Scheduled(cron = "*/2 * * * * ?")
//    public void task3() {
//        System.out.println("每2秒执行一次！");
//    }
}
