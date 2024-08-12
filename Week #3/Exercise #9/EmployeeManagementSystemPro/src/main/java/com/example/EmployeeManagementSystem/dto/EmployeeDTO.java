package com.example.EmployeeManagementSystem.dto;

import lombok.*;

@Getter
@Setter
public class EmployeeDTO {
	
	private Long id;
	private String namee;
	private String email;
	private String departmentName;
	
	public EmployeeDTO(Long id, String name, String email, String departmentName) {
		this.id = id;
		this.namee = name;
		this.email = email;
		this.departmentName = departmentName;
	}
}
