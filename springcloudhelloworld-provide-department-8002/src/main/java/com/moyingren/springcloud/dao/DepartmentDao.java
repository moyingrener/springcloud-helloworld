package com.moyingren.springcloud.dao;

import com.moyingren.springcloud.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentDao {
    public boolean addDept(Department dept);

    public Department findById(Long id);

    public List<Department> findAll();
}
