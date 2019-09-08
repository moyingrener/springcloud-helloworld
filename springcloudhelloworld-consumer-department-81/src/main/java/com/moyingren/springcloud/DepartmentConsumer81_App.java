package com.moyingren.springcloud;

import com.moyingren.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(value = "MOYINGREN-DEPARTMENT",configuration = MyRule.class)//开启自定义配置rule
public class DepartmentConsumer81_App {
    public static void main(String[] args) {
        SpringApplication.run(DepartmentConsumer81_App.class,args);
    }
}
