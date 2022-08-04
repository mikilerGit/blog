package com.xupt.view;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.xupt")
@MapperScan(basePackages = "com.xupt.common.mapper")
public class ViewApplication {
    public static void main(String[] args) {
       SpringApplication.run(ViewApplication.class,args);

    }
}
