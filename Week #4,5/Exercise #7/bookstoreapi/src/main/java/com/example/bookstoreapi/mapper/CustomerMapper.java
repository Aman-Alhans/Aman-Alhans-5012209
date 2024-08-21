package com.example.bookstoreapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.bookstoreapi.dto.CustomerDTO;
import com.example.bookstoreapi.entity.Customer;

@Mapper
public interface CustomerMapper {
	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	CustomerDTO toDTO(Customer customer);
	
	Customer toEntity(CustomerDTO customerDTO);
}
