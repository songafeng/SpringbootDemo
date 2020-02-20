package com.example.controller;

import com.example.utils.JwtUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @RequestMapping("/login")
    public String Login(String username, String pwd, HttpServletRequest request, HttpServletResponse response)
    {
        if(!username.equals("afeng")|| !pwd.equals("111111"))
        {
            return "密码不正确";
        }

        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("uname",username);
        claims.put("pwd", pwd);
        String jwt = JwtUtils.createJwt(claims, JwtUtils.JWT_WEB_TTL);
        response.setHeader(JwtUtils.JWT_HEADER_KEY, jwt);
        return "登录成功";
    }

    @RequestMapping(value="/getuserinfo")
    public String GetUserInfo()
    {
        System.out.println("已经经过验证过的");
        return "from getuserinfo";
    }
}
