package com.ffk.sofabootuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.sofabootcommon.mapper")
public class SofaBootUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SofaBootUserApplication.class, args);
    }

}
