package com.moyingren.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//本服务启动后自动注册金eureka
@EnableDiscoveryClient//开启服务发现
@EnableCircuitBreaker//开启熔断机制Hystrix
public class DepartmentProviderHystrix8001_App {
    public static void main(String[] args) {
        SpringApplication.run(DepartmentProviderHystrix8001_App.class, args);
    }
}
