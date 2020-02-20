package com.example.test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.utils.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;
import org.junit.Test;


import io.jsonwebtoken.Claims;

public class JwtDemo {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Test
    public void test1() {// 生成JWT
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("username", "zss");
        claims.put("age", 18);

        String jwt = JwtUtils.createJwt(claims, JwtUtils.JWT_WEB_TTL);
        System.out.println(jwt);

        Claims parseJwt = JwtUtils.parseJwt(jwt);
        for (Map.Entry<String, Object> entry : parseJwt.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        Date d1 = parseJwt.getIssuedAt();
        Date d2 = parseJwt.getExpiration();
        System.out.println("令牌签发时间：" + sdf.format(d1));
        System.out.println("令牌过期时间：" + sdf.format(d2));
    }

    @Test
    public void test2() {// 解析oldJwt
//        String oldJwt = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI5MDMzNjAsImlhdCI6MTU2MjkwMTU2MCwiYWdlIjoxOCwianRpIjoiZDVjMzE4Njg0MDcyNDgyZDg1MDE5ODVmMDY3OGQ4NjkiLCJ1c2VybmFtZSI6InpzcyJ9.XDDDRRq5jYq5EdEBHtPm7GcuBz4S0VhDTS1amRCdf48";
//        String oldJwt = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjM1MjU5MjMsImlhdCI6MTU2MzUyNDEyMywiYWdlIjoxOCwianRpIjoiOTAzNmMwY2Q3NGIwNDBjMzgzMDAxYzdiNmZkMzYzZmIiLCJ1c2VybmFtZSI6InpzcyJ9.sgV9fr4fgmmahDFRJnsfazA6R3H-gNMVcg2ucA227n4";
        String oldJwt = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NzkwNjA2NTQsImlhdCI6MTU3OTA1ODg1NCwiYWdlIjoxOCwianRpIjoiNTc4YjI2NDY2ODBiNGYwZTgyN2VkY2E5YjU2NmFhMWQiLCJ1c2VybmFtZSI6InpzcyJ9.iA5AshK1kCTA8g6rsEgFy4yVL4sVKekmSoSZHFdLU8Y";
        Claims parseJwt = JwtUtils.parseJwt(oldJwt);
        for (Map.Entry<String, Object> entry : parseJwt.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        Date d1 = parseJwt.getIssuedAt();
        Date d2 = parseJwt.getExpiration();
        System.out.println("令牌签发时间：" + sdf.format(d1));
        System.out.println("令牌过期时间：" + sdf.format(d2));
    }

    @Test
    public void test3() {// 复制jwt，并延时30秒
//        String oldJwt = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI5MDMzNjAsImlhdCI6MTU2MjkwMTU2MCwiYWdlIjoxOCwianRpIjoiZDVjMzE4Njg0MDcyNDgyZDg1MDE5ODVmMDY3OGQ4NjkiLCJ1c2VybmFtZSI6InpzcyJ9.XDDDRRq5jYq5EdEBHtPm7GcuBz4S0VhDTS1amRCdf48";
        String oldJwt = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NzkwNjA2NTQsImlhdCI6MTU3OTA1ODg1NCwiYWdlIjoxOCwianRpIjoiNTc4YjI2NDY2ODBiNGYwZTgyN2VkY2E5YjU2NmFhMWQiLCJ1c2VybmFtZSI6InpzcyJ9.iA5AshK1kCTA8g6rsEgFy4yVL4sVKekmSoSZHFdLU8Y";
        String jwt = JwtUtils.copyJwt(oldJwt, JwtUtils.JWT_WEB_TTL);
        Claims parseJwt = JwtUtils.parseJwt(jwt);
        for (Map.Entry<String, Object> entry : parseJwt.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        Date d1 = parseJwt.getIssuedAt();
        Date d2 = parseJwt.getExpiration();
        System.out.println("令牌签发时间：" + sdf.format(d1));
        System.out.println("令牌过期时间：" + sdf.format(d2));
    }

    @Test
    public void test4() {// 测试JWT的有效时间
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("username", "zss");
        String jwt = JwtUtils.createJwt(claims, 3 * 1000L);
        System.out.println(jwt);
        Claims parseJwt = JwtUtils.parseJwt(jwt);
        Date d1 = parseJwt.getIssuedAt();
        Date d2 = parseJwt.getExpiration();
        System.out.println("令牌签发时间：" + sdf.format(d1));
        System.out.println("令牌过期时间：" + sdf.format(d2));
    }

    @Test
    public void test5() {// 三秒后再解析上面过期时间只有三秒的令牌，因为过期则会报错io.jsonwebtoken.ExpiredJwtException
        String oldJwt = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjI4NTMzMzAsImlhdCI6MTU2Mjg1MzMyNywidXNlcm5hbWUiOiJ6c3MifQ.e098Vj9KBlZfC12QSDhI5lUGRLbNwb27lrYYSL6JwrQ";
        try {
            Claims parseJwt = JwtUtils.parseJwt(oldJwt);
            // 过期后解析就报错了，下面代码根本不会执行
            Date d1 = parseJwt.getIssuedAt();
            Date d2 = parseJwt.getExpiration();
            System.out.println("令牌签发时间：" + sdf.format(d1));
            System.out.println("令牌过期时间：" + sdf.format(d2));
        }
        catch(ExpiredJwtException e)
        {
            System.out.println("签名过期");
        }
    }
}