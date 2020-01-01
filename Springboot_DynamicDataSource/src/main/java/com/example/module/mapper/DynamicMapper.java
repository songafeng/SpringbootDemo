package com.example.module.mapper;

import com.example.module.condition.DynamicCondition;
import com.example.util.DBHelper;
import com.example.util.DS;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DynamicMapper {
    List<DynamicCondition> getListFromSource1();

    @DS(DBHelper.DB_TYPE_R)
    List<DynamicCondition> getListFromSource2();
}
