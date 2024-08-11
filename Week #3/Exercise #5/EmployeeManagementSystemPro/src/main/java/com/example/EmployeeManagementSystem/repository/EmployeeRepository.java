package com.example.EmployeeManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.EmployeeManagementSystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

	@Query("SELECT emp FROM Employee emp WHERE emp.name = :name")
	List<Employee> findByName(@Param("name") String name);
	
	List<Employee> findByDepartmentId(@Param("DepartmentId") Long departmentId);
}
