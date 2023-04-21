package com.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
 public class Employee {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "email")
  private String email;
  
  @Column(name = "department")
  private String department;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department + "]";
}

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

public Employee(Long id, String name, String email, String department) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.department = department;
}
  
  // getters and setters
  
}
