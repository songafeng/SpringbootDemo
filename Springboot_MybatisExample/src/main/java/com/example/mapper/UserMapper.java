package com.example.mapper;

import com.example.common.BaseMapper;
import com.example.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    User Sel(int id);
}
