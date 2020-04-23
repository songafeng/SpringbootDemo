package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "com.example.service-provider")
public interface TestClientFeign {

    @GetMapping(value = "/echo/{str}")
    String echo(@PathVariable("str") String str);
}
