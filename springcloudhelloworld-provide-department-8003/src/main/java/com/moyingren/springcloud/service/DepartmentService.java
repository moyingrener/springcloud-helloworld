package com.moyingren.springcloud.service;

import com.moyingren.springcloud.pojo.Department;

import java.util.List;

public interface DepartmentService {
    public boolean add(Department dept);

    public Department get(Long id);

    public List<Department> list();
}
