package com.moyingren.springcloud.controller;

import com.moyingren.springcloud.pojo.Department;
import com.moyingren.springcloud.service.DepartmentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController_Consumer {
    @Autowired
    private DepartmentClientService service;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Department get(@PathVariable("id") Long id)
    {
        return this.service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Department> list()
    {
        return this.service.list();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Department dept)
    {
        return this.service.add(dept);
    }
}
