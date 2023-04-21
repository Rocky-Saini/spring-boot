package com.crud.serviceimpl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.entity.Employee;
import com.crud.repository.EmployeeRepository;
import com.crud.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
  
  @Autowired
  private EmployeeRepository employeeRepository;
  
  @Override
  public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }
  
  @Override
  public Employee getEmployeeById(Long id) {
    return employeeRepository.findById(id)
        .orElseThrow();
  }
  
  @Override
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }
  
  @Override
  public Employee updateEmployee(Long id, Employee employee) {
    Employee existingEmployee = employeeRepository.findById(id)
        .orElseThrow();
    existingEmployee.setName(employee.getName());
    existingEmployee.setEmail(employee.getEmail());
    existingEmployee.setDepartment(employee.getDepartment());
    return employeeRepository.save(existingEmployee);
  }
  
  @Override
  public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
  }
  
}
