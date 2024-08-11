package com.example.EmployeeManagementSystem.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.EmployeeManagementSystem.entity.Department;
import com.example.EmployeeManagementSystem.repository.DepartmentRepository;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@PostMapping
	public Department createDepartment(@RequestBody Department department) {
		return departmentRepository.save(department);
	}
	
	@GetMapping
	public List<Department> getAllDepartments(){
		return departmentRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
		Optional<Department> department = departmentRepository.findById(id);
		return department.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails){
		Optional<Department> department = departmentRepository.findById(id);
		
		if(department.isPresent()) {
			Department exisitngDepartment = department.get();
			exisitngDepartment.setName(departmentDetails.getName());
			
			Department updateDepartment = departmentRepository.save(exisitngDepartment);
			return ResponseEntity.ok(updateDepartment);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Void> deleteDepartment(@PathVariable Long id){
		if(departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}