package com.example.reactcrud.service;

import com.example.reactcrud.entity.Employee;

import java.util.List;

public interface Services {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee,int id);

    void deleteEmployee(Integer id);

    Employee getEmployeeById(Integer id);

    List<Employee> getEmployees();
}
