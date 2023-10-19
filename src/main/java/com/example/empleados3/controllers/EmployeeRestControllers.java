package com.example.empleados3.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.validation.annotation.Validated;

import com.example.empleados3.validators.OnCreate;
import com.example.empleados3.model.Employee;
import com.example.empleados3.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestControllers {
	
	ArrayList<Employee> listaEmployee=new ArrayList<>(
			Arrays.asList(new Employee(1, "Juan", "juan@gmail.com","Emp-Rhh-1234"),
					new Employee(2, "Maria", "Maria@gmail.com","Emp-Rhh-1245"),
					new Employee(3, "Enrique", "enrique@gmail.com","Emp-Rpp-1256")
			));
	
	EmployeeService employeeService;

	public EmployeeRestControllers(@Qualifier("generales") EmployeeService employeeService) {
		this.employeeService=employeeService;
	}

	//endpoints
	
	@GetMapping
	public ResponseEntity<?> getEmployee(@PathVariable int id){
		if(id<0) {
			return ResponseEntity.badRequest().build();
		}
		for(Employee e:listaEmployee) {
			if(e.getId()==id);
				return ResponseEntity.ok(e);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> createEmployee(@RequestBody @Validated(OnCreate.class)Employee employee){
		Employee newEmployee=this.employeeService.saveEmployee(employee);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	@DeleteMapping
	public ResponseEntity deleteEmployee(@PathVariable int id) {
		if(id<0) {
			return ResponseEntity.badRequest().build();
		}
		
		for(Employee e:new ArrayList<>(listaEmployee)) {
			if(e.getId()==id) {
				listaEmployee.remove(e);
				return ResponseEntity.noContent().build();
				
			}
			
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping
	public ResponseEntity<?> updateEmployee(@RequestBody @Validated Employee employee){
		for(Employee e: listaEmployee) {
			if(e.getId()==employee.getId()) {
				e.setName(employee.getName());
				e.setEmail(employee.getEmail());
				e.setEmployeeCode(employee.getEmployeeCode());
			}
		}
		
		return ResponseEntity.notFound().build();
		
	}
}
