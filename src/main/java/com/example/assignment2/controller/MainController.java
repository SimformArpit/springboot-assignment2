package com.example.assignment2.controller;

import com.example.assignment2.entity.Employee;
import com.example.assignment2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class MainController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
      return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findUserById(@PathVariable("id") int id) {

        return ResponseEntity.ok().body(employeeService.findUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") int id) {
        employeeService.deleteUserById(id);
        return new ResponseEntity<>("Message : User deleted of ID " + id , HttpStatus.ACCEPTED);
    }
    @GetMapping("/sortByName")
    public ResponseEntity<List<Employee>> sortEmployeeByName(){
    return new ResponseEntity<>(employeeService.sortEmployeeByName(),HttpStatus.OK);
    }


}
