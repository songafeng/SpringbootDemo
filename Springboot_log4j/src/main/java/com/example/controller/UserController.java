package com.example.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jdd on 2019/12/5.
 */
@RestController
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);
    @RequestMapping("hello")
    public String Hello(){
        logger.debug("debug message");
        logger.warn("warn message");
        logger.info("info message");
        logger.error("error message");
        logger.trace("trace message");
        return "ok";
    }

}
