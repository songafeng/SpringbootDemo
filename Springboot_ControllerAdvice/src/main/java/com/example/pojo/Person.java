package com.example.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by jdd on 2020/1/1.
 */
public class Person {
    @JSONField(name = "name") // 注意观察生成的JSON串中name和age的区别
    private String name;
    @JSONField(name = "AGE")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}