package com.example.controller;

import com.example.service.UserService;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

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

    @Autowired
    RedisUtil redisUtil;


    @RequestMapping("test")
    public String test() throws Exception{
        try {
            InputStream inputStream=Object.class.getResourceAsStream("connector.properties");

            Properties properties = new Properties();
            properties.load(inputStream);
            System.out.println("name:"+properties.get("name"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "ok";
    }


    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        redisUtil.HashSet("1001","12346");

        return userService.Sel(id).toString();
    }


}
