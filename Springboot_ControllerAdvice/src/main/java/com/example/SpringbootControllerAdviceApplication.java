package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//通过@ControllerAdvice设置controller的全局异常处理
@SpringBootApplication
public class SpringbootControllerAdviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootControllerAdviceApplication.class, args);
	}

}
