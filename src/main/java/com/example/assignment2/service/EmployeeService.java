package com.example.assignment2.service;

import com.example.assignment2.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void createEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee findUserById(int id);
    void deleteUserById(int id);
    List<Employee> sortEmployeeByName();
}
