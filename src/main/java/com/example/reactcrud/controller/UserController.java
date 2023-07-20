package com.example.reactcrud.controller;

import com.example.reactcrud.entity.Employee;
import com.example.reactcrud.service.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private final Services services;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return services.getEmployees();
    }

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee){
        System.out.println(employee.getSalary());
        return services.saveEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable int id){
        return services.updateEmployee(employee,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        services.deleteEmployee(id);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return services.getEmployeeById(id);
    }
}
