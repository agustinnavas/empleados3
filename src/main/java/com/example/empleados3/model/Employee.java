package com.example.empleados3.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class Employee {

	//atributos clase
	@NotNull(message = "")
	private Integer id;
	

	@NotNull(message = "")
	@NotBlank()
	private String name;
	
	
	@NotBlank()
	@Email(message = "")
	private String email;
	
	@NotNull(message = "")
	private String employeeCode;

	
	//constructor
	
	public Employee(Integer id, String name, String email, String employeeCode) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.employeeCode = employeeCode;
	}

	//getter y setter

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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


	public String getEmployeeCode() {
		return employeeCode;
	}


	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	//metodo tostring

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", employeeCode=" + employeeCode + "]";
	}
	
	
	
}


