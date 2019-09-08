package com.moyingren.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard//开启hystrix仪表板监控
public class DepartmentConsumerHystrixDashboard9001_App {
    public static void main(String[] args) {
        SpringApplication.run(DepartmentConsumerHystrixDashboard9001_App.class,args);
    }
}
