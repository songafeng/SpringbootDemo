package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:23
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User Sel(int id){
        return userMapper.Sel(id);
    }

    public User GetOne(int id){

        User user=userMapper.selectByPrimaryKey(id);
        return user;
    }

    public List<User> ListUser(String username)
    {
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userName",username);

        List<User> list=userMapper.selectByExample(example);

        return list;
    }

    public List<User> ListUserByPage(int pageNum,int pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);

        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        List<User> list=userMapper.selectByExample(example);

        return list;
    }
}
