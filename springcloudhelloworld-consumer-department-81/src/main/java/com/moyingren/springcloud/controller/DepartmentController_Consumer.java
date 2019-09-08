package com.moyingren.springcloud.controller;

import com.moyingren.springcloud.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DepartmentController_Consumer {
    @Autowired
    private RestTemplate restTemplate;

    //private static final String REST_URL_PREFIX="http://localhost:8001";
    private static final String REST_URL_PREFIX="http://MOYINGREN-DEPARTMENT";

    @PostMapping("/consumer/dept/add")
    public boolean add(Department department){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",department,Boolean.class);
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Department get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Department.class);
    }

    @GetMapping("/consumer/dept/list")
    public List<Department> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

    @GetMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
    }
}
