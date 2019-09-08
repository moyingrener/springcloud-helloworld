package com.moyingren.springcloud.controller;

import com.moyingren.springcloud.pojo.Department;

import com.moyingren.springcloud.service.DepartmentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Department dept) {
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Department get(@PathVariable("id") Long id) {
        Department d=service.get(id);
        if (d==null){
            throw new RuntimeException("该ID"+id+"没有相应的信息");
        }
        return d;
    }

    public Department processHystrix_Get(@PathVariable("id") Long id)
    {       Department d=new Department();
            d.setDeptno(id);
            d.setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand");
            d.setDb_source("no this database in MySQL");
        return d;
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Department> list() {
        return service.list();
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MOYINGREN-DEPARTMENT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }
}
