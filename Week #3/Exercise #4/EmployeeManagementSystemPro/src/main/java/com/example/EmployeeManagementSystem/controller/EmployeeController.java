package com.example.EmployeeManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails){
		Optional<Employee> employee = employeeRepository.findById(id);
		
		if(employee.isPresent()) {
			Employee exisitingEmployee = employee.get();
			exisitingEmployee.setName(employeeDetails.getName());
			exisitingEmployee.setEmail(employeeDetails.getEmail());
			exisitingEmployee.setDepartment(employeeDetails.getDepartment());
			
			Employee updateEmployee = employeeRepository.save(exisitingEmployee);
			return ResponseEntity.ok(updateEmployee);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
		if(employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
