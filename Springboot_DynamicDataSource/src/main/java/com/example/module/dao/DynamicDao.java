package com.example.module.dao;

import com.example.module.condition.DynamicCondition;
import com.example.module.mapper.DynamicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DynamicDao {

    @Autowired
    DynamicMapper dynamicMapper;

    public List<DynamicCondition> getListFromSource1(){
        return dynamicMapper.getListFromSource1();
    }

    public List<DynamicCondition> getListFromSource2(){
        return dynamicMapper.getListFromSource2();
    }
}
