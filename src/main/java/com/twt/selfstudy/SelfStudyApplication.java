package com.twt.selfstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@EnableScheduling 
public class SelfStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelfStudyApplication.class, args);
    }

}
