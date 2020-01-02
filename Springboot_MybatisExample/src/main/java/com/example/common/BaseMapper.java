package com.example.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by wjd on 2019/4/19.
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {


}