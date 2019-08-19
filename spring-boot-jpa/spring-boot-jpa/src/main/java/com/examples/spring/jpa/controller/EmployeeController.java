package com.examples.spring.jpa.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examples.spring.jpa.exceptions.EmployeeNotFoundExceptions;
import com.examples.spring.jpa.model.Employee;
import com.examples.spring.jpa.repository.EmployeeRepository;


@RestController
@RequestMapping("/api")
public class EmployeeController {

	 @Autowired
	 EmployeeRepository  employeeRepository;
	
	
	//Get All employee details
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		System.out.println("Display the Data of Employee");
		return employeeRepository.findAll();
	}

	
	
	//save all employee details

	@PostMapping("/employees")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Employee> createEmployees(@Valid @RequestBody List<Employee> emp){
		
		try {
		employeeRepository.saveAll(emp);
		System.out.println(emp);
		return emp;
			
	}catch (Exception e) {
		// TODO: handle exception
		
		System.out.println(e);
	}
		return null;

}
	

	
	//get particular employee details
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable(value="id") Long id) {
		
		return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundExceptions::new);
	}

	
	
	//update employee details
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable(value="id") Long id 
			,@Valid @RequestBody Employee emp)
	{
		Employee empToUpdate=employeeRepository.findById(id).orElseThrow
				(EmployeeNotFoundExceptions::new);
		//empToUpdate.setName(emp.getName());
		empToUpdate.setAddress(emp.getAddress());
		empToUpdate.setStatus(emp.getStatus());
		empToUpdate.setContact_No(emp.getContact_No());
		empToUpdate.setEmail_Id(emp.getEmail_Id());
		
	
		return employeeRepository.save(empToUpdate);
	}
	
	
	//delete employee 
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable(value="id") Long id) {
		
		employeeRepository.findById(id).orElseThrow(EmployeeNotFoundExceptions::new);
		employeeRepository.deleteById(id);
		return "employee is deleted";
	}
}
	

	
	
