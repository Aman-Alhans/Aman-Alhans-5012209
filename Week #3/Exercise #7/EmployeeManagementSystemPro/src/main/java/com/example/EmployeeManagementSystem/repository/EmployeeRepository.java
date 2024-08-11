package com.example.EmployeeManagementSystem.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.EmployeeManagementSystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

	@Query("SELECT emp FROM Employee emp WHERE emp.name = :name")
	Page<Employee> findByName( String name, Pageable pageable);
	
	Page<Employee> findByDepartmentId(Long departmentId , Pageable pageable);
	
	Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);
}
