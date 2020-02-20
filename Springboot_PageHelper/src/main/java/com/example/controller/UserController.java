package com.example.controller;

import com.example.common.PageInfo;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 14:42
 */

@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.Sel(id).toString();
    }

    @RequestMapping("getOne/{id}")
    public String GetOne(@PathVariable int id){
        return userService.GetOne(id).toString();
    }

    @RequestMapping("listUser")
    public String listUser(){
        return userService.ListUser("jiasheng").toString();
    }

    //http://localhost:8080/testBoot/listUserPage?pageNum=1&pageSize=2
    @RequestMapping("listUserPage")
    public PageInfo<User> listUserPage(int pageNum,int pageSize){
        List<User> result=userService.ListUserByPage(pageNum,pageSize);

        return new PageInfo<User>(result);
    }
}
