package com.example.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EmployeeManagementSystem.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	Department findByName(String name);
}
