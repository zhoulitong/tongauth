package com.zlt.liao.tongauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zlt.liao.tongauth.dao")
public class TongauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(TongauthApplication.class, args);
    }
}
