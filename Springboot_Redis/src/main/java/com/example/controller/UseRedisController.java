package com.example.controller;

import com.example.util.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jdd on 2019/12/27.
 */
@RestController
public class UseRedisController {

    @Autowired
    RedisService redisService;

    @RequestMapping("/redis")
    public String redis() throws Exception{
        redisService.set("redis","song");
        return "ok";
    }
}
