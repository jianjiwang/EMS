package com.baizhi.dao;

import com.baizhi.entity.Employees;

import java.util.List;

public interface EmployeesDao {
    public void insert(Employees employees);

    public List<Employees> selectAll(Integer id);

    public void delete(Integer id);

    public Employees selectOne(Integer id);

    public void update(Employees employees);
}
