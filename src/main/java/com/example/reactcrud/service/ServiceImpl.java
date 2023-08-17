package com.example.reactcrud.service;

import com.example.reactcrud.entity.Employee;
import com.example.reactcrud.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements Services {

    @Autowired
    private final EmployeeRepo employeeRepo;



    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee,int id) {
        Employee existingEmployee = employeeRepo.findById(id).orElseThrow();
            existingEmployee.setName(employee.getName());
            existingEmployee.setAddress(employee.getAddress());
            existingEmployee.setSalary(employee.getSalary());
            return employeeRepo.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        List<Employee> employee=employeeRepo.findAll();
        employee.stream().filter(e->e.getId()==id).forEach(employeeRepo::delete);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }
}
