package com.crud.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Employee;
import com.crud.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
  
  @Autowired
  private EmployeeService employeeService;
  // create a new employee
  @PostMapping("/")
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    Employee createdEmployee = employeeService.createEmployee(employee);
    return ResponseEntity.created(URI.create("/employees/" + createdEmployee.getId()))
        .body(createdEmployee);
  }
  
  // get an employee by id
  @GetMapping("/{id}")
  public Employee getEmployeeById(@PathVariable Long id) {
    return employeeService.getEmployeeById(id);
  }
  
  // get all employees
  @GetMapping("/")
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }
  
  // update an employee by id
  @PutMapping("/{id}")
  public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
    return employeeService.updateEmployee(id, employee);
  }
  
  // delete an employee by id
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
    employeeService.deleteEmployee(id);
    return ResponseEntity.noContent().build();
  }
}
