package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jdd on 2019/12/31.
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping("/doNormal")
    public String doNormal(String name, String age) {
        log.info("【执行方法】：doNormal");
        return "doNormal";
    }

    @GetMapping("/doWithException")
    public String doWithException(String name, String age) {
        log.info("【执行方法】：doWithException");
        int a = 1 / 0;
        return "doWithException";
    }

}