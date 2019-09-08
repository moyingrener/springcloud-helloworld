package com.moyingren.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloud_Config_3344 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloud_Config_3344.class,args);
    }
}
