package com.example;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@NacosPropertySource(dataId = "com.example", autoRefreshed = true)
@MapperScan("com.example.mapper") //扫描的mapper
@SpringBootApplication
public class SpringbootNacosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootNacosApplication.class, args);
	}

}
