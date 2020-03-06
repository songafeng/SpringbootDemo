package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private Person person;

    @RequestMapping("get")
    public Person get(){
        person = new Person();
        person.setName("gyl");
        person.setAge("20");

        String jsonStr = JSONObject.toJSONString(person);
        System.out.println("bean to json:" + jsonStr);
        person = JSONObject.toJavaObject(JSONObject.parseObject(jsonStr), Person.class);
        System.out.println("json to bean:" + person.getName());

        logger.debug("debug message");
        logger.warn("warn message");
        logger.info("info message");
        logger.error("error message");
        logger.trace("trace message");
        return person;
    }

}
