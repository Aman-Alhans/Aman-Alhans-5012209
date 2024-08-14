package com.example.EmployeeManagementSystem.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagementSystem.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	Page<Department> findAll(Pageable pageable);
	
	Department findByName(String name);

    @Query("SELECT d FROM Department d WHERE d.name = :name")
    Department findByDepartmentName(@Param("name") String name);
}
