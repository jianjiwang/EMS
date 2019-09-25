package com.baizhi.service;

import com.baizhi.dao.EmployeesDao;
import com.baizhi.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeesServiceImpl implements EmployeesService {
    @Autowired
    private EmployeesDao employeesDao;

    public void insert(Employees employees){
        employeesDao.insert(employees);
    }

    @Override
    public List<Employees> selectAll(Integer id) {
        List<Employees> employees = employeesDao.selectAll(id);
        return employees;
    }

    @Override
    public void delete(Integer id) {
        employeesDao.delete(id);
    }

    @Override
    public Employees selectOne(Integer id) {
        Employees employees = employeesDao.selectOne(id);
        return employees;
    }

    @Override
    public void update(Employees employees) {
        employeesDao.update(employees);
    }


}
