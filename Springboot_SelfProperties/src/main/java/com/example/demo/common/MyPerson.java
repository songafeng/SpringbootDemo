package com.example.demo.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource(value = {"classpath:person.properties","file:${spring.profiles.path}/person.properties"},ignoreResourceNotFound = true)

public class MyPerson {

    @Value("${user.address}")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
