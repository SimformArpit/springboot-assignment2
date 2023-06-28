package com.example.assignment2.service;

import com.example.assignment2.entity.Employee;
import com.example.assignment2.exception.UserNotFoundException;
import com.example.assignment2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findUserById(int id) {
        Employee byId = employeeRepository.findById(id);

        if (byId == null) {
            throw new UserNotFoundException();
        }
        return byId;
    }

    public void deleteUserById(int id) {
        Employee byId = employeeRepository.findById(id);
        if (byId == null) {
            throw new UserNotFoundException();
        } else {
            employeeRepository.deleteById(id);
        }
    }

    public List<Employee> sortEmployeeByName() {
        return employeeRepository.findAll().stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList());
    }
}


