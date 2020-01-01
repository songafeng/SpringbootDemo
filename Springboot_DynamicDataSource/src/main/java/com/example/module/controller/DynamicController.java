package com.example.module.controller;


import com.example.module.condition.DynamicCondition;
import com.example.module.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("dynamic")
public class DynamicController {
    @Autowired
    private DynamicService dynamicService;

    @ResponseBody
    @RequestMapping("source1")
    public List<DynamicCondition> getListFromSource1(){
        return dynamicService.getListFromSource1();
    }

    @ResponseBody
    @RequestMapping("source2")
    public List<DynamicCondition> getListFromSource2(){
        return dynamicService.getListFromSource2();
    }
}
