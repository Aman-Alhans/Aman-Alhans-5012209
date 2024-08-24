package com.example.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomerDTO {
	
	private Long id;
	
	@JsonProperty("full_name")
	private String name;
	
	private String email;
	
	@JsonProperty("phone")
	private String phoneNumber;
}
