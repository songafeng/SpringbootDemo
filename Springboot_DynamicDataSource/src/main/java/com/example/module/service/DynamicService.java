package com.example.module.service;

import com.example.module.condition.DynamicCondition;
import com.example.module.dao.DynamicDao;
import com.example.util.DBHelper;
import com.example.util.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicService {
    @Autowired
    DynamicDao dynamicDao;

    public List<DynamicCondition> getListFromSource1(){
        return dynamicDao.getListFromSource1();
    }


    public List<DynamicCondition> getListFromSource2(){
        return dynamicDao.getListFromSource2();
    }
}
