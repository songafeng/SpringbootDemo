package com.example.controller;

import com.example.baseClass.ResultInfo;
import com.example.exception.ServiceException;
import com.example.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jdd on 2020/1/4.
 */
@Controller
public class UserController {


    @RequestMapping("hello")
    @ResponseBody
    public ResultInfo<Person> Hello(){

        Person person=new Person();
        person.setName("afeng");
        person.setAge("40");
        ResultInfo<Person> personResultInfo=new ResultInfo<Person>(200,person,"ok");

        throw new ServiceException("这是一个自定义异常");

//        return personResultInfo;
    }
}
