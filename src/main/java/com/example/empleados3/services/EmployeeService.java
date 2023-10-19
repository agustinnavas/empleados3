package com.example.empleados3.services;

import java.util.ArrayList;
import com.example.empleados3.model.Employee;


public interface EmployeeService {
	
	public ArrayList<Employee> getAllEmpleados();
	
	public Employee saveEmployee(Employee employee);


}