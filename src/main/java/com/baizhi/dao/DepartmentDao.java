package com.baizhi.dao;

import com.baizhi.entity.Department;

import java.util.List;

public interface DepartmentDao {
    public List<Department> selectAll();

    public Department selectOne(Integer id);

    public void update(Department department);

    public void insert(Department department);
}
