package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.example.mapper") //扫描的mapper
@SpringBootApplication
public class SpringbootMybatisExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisExampleApplication.class, args);
	}

}
