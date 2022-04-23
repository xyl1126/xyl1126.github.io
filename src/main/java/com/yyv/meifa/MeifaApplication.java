package com.yyv.meifa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yyv.meifa.mapper")
public class MeifaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeifaApplication.class, args);
    }

}
