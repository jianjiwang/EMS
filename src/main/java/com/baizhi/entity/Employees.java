package com.baizhi.entity;

public class Employees {
    private Integer id;
    private String picture;
    private String name;
    private Integer age;
    private Double salary;
    private Integer did;
    private Department department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employees(Integer id, String picture, String name, Integer age, Double salary, Integer did, Department department) {
        this.id = id;
        this.picture = picture;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.did = did;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", did=" + did +
                ", department=" + department +
                '}';
    }

    public Employees() {
    }
}
