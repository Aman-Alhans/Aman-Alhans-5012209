package com.example.bookstoreapi.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.bookstoreapi.mapper.*;

@Configuration
public class MapperConfig {
	
	@Bean
	public BookMapper bookMapper() {
		return Mappers.getMapper(BookMapper.class);
	}
	
	@Bean
    public CustomerMapper customerMapper() {
        return Mappers.getMapper(CustomerMapper.class);
    }
}
