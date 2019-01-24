package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication(scanBasePackages = {"com.example.base", "com.example.sys"})
@MapperScan("com.example.sys.mapper")
@EnableCaching
public class DemoApplication {

	@RequestMapping("/")
	public String toIndex() {
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}