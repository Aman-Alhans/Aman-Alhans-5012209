package com.example.bookstoreapi.mapper;

import org.mapstruct.Mapper;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.model.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
	
	BookDTO toDTO(Book book);
	
	Book toEntity(BookDTO bookDTO);
	
}
