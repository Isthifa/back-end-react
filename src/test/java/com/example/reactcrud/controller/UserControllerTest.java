package com.example.reactcrud.controller;

import com.example.reactcrud.entity.Employee;
import com.example.reactcrud.service.Services;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    Services services;

    @InjectMocks
    UserController userController;

    @Test
    @DisplayName("Should return all employees")
    void getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "John Doe", "123 Main St", 5000.0));
        employeeList.add(new Employee(2, "Jane Smith", "456 Elm St", 6000.0));

        when(services.getEmployees()).thenReturn(employeeList);

        List<Employee> result = userController.getEmployees();

        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("123 Main St", result.get(0).getAddress());
        assertEquals(5000.0, result.get(0).getSalary());
        assertEquals("Jane Smith", result.get(1).getName());
        assertEquals("456 Elm St", result.get(1).getAddress());
        assertEquals(6000.0, result.get(1).getSalary());

        verify(services, times(1)).getEmployees();
    }

    @Test
    @DisplayName("Should save employee")
    void saveEmployee(){
        Employee employee = new Employee(1, "John Doe", "123 Main St", 5000.0);

        when(services.saveEmployee(employee)).thenReturn(employee);

        Employee result = userController.saveEmployee(employee);

        assertEquals(1, result.getId());
        assertEquals("John Doe", result.getName());
        assertEquals("123 Main St", result.getAddress());
        assertEquals(5000.0, result.getSalary());
        verify(services, times(1)).saveEmployee(employee);
    }

    @Test
    @DisplayName("Should update employee")
    void updateEmployee()
    {
        Employee employee = new Employee(1, "John Doe", "123 Main St", 5000.0);

        when(services.updateEmployee(employee,1)).thenReturn(employee);

        Employee result = userController.updateEmployee(employee,1);

        assertEquals(1, result.getId());
        assertEquals("John Doe", result.getName());
        assertEquals("123 Main St", result.getAddress());
        assertEquals(5000.0, result.getSalary());
        verify(services, times(1)).updateEmployee(employee,1);
    }

    @Test
    @DisplayName("Should delete employee")
    void deleteEmployee()
    {
        userController.deleteEmployee(1);
        verify(services, times(1)).deleteEmployee(1);
    }

}



