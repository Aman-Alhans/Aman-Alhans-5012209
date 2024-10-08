package com.example.EmployeeManagementSystem.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EmployeeManagementSystem.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	Page<Department> findAll(Pageable pageable);
}
