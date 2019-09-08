package com.moyingren.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {
    @Bean//自定义rule
    public IRule myrule(){
       return new RandomRule_ZDY();
    }
}
