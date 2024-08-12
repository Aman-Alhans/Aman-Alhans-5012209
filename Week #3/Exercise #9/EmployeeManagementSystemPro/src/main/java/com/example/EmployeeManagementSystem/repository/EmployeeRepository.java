package com.example.EmployeeManagementSystem.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagementSystem.dto.EmployeeDTO;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.projections.EmployeeProjection;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

	@Query("SELECT emp FROM Employee emp WHERE emp.name = :name")
	Page<Employee> findByName( String name, Pageable pageable);
	
	Page<Employee> findByDepartmentId(Long departmentId , Pageable pageable);
	
	Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);
	
	//METHOD FOR PROJECTION USING PROJECTION INTERFACE
	@Query("Select emp.id AS Id, emp.name AS Name, emp.email as Email, dept.name as Department_Name FROM Employee emp JOIN emp.department dept ")
	List<EmployeeProjection> findAllEmployeeProjections();
	
	//METHOD FOR PROJECTION USING DTO CLASS
	@Query("Select new com.example.EmployeeMangementSystem.dto.EmployeeDTO(emp.id, emp.name, emp.email, dept.name) FROM Employee emp JOIN emp.department dept")
	List<EmployeeDTO> findAllEmployeeDTOS();
	
	Employee findByName(String name);

    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmail(@Param("email") String email);
}
