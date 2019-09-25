package com.baizhi.service;

import com.baizhi.entity.Employees;

import java.util.List;

public interface EmployeesService {
    public void insert(Employees employees);

    public List<Employees> selectAll(Integer id);

    public void delete(Integer id);

    public Employees selectOne(Integer id);

    public void update(Employees employees);
}