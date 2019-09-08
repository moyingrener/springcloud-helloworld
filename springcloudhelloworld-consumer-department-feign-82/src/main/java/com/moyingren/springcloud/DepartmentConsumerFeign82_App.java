package com.moyingren.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.moyingren.springcloud"})
//@ComponentScan("com.moyingren.springcloud")
public class DepartmentConsumerFeign82_App {
    public static void main(String[] args) {
        SpringApplication.run(DepartmentConsumerFeign82_App.class,args);
    }
}
