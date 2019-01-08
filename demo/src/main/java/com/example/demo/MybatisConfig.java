package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.example.demo.mapper")
public class MybatisConfig {

}
