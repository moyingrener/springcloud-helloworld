package com.moyingren.springcloud.service;

import com.moyingren.springcloud.pojo.Department;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "MOYINGREN-DEPARTMENT",fallbackFactory = DepartmentClientServiceFallbackFactory.class)
public interface DepartmentClientService {
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Department get(@PathVariable("id") Long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Department> list();

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Department dept);
}
