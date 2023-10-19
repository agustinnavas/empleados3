package com.example.empleados3.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.empleados3.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Primary
@Service("generales")
//@ConditionalOnProperty(prefix ="implementacion", value ="persona", havingValue = "generaless")
public class EmployeeServiceImpl implements EmployeeService {

	ArrayList<Employee> listaEmployee=new ArrayList<>(
			Arrays.asList(new Employee(1, "Juan", "juan@gmail.com","Emp-Rhh-1234"),
					new Employee(2, "Maria", "Maria@gmail.com","Emp-Rhh-1245"),
					new Employee(3, "Enrique", "enrique@gmail.com","Emp-Rpp-1256")
			));

	@Override
	public ArrayList<Employee> getAllEmpleados() {
		return listaEmployee;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		this.listaEmployee.add(employee);
		return employee;
	}

	
	
	
	
}
