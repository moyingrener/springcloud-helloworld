package com.moyingren.springcloud.service;

import com.moyingren.springcloud.pojo.Department;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DepartmentClientServiceFallbackFactory implements FallbackFactory<DepartmentClientService> {
    @Override
    public DepartmentClientService create(Throwable throwable) {
        return new DepartmentClientService() {
            @Override
            public Department get(Long id) {
                Department d=new Department();
                d.setDeptno(id);
                d.setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
                d.setDb_source("no this database in MySQL");
                return d;
            }

            @Override
            public List<Department> list() {
                return null;
            }

            @Override
            public boolean add(Department dept) {
                return false;
            }
        };
    }
}
