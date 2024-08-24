package com.example.bookstoreapi.mapper;

import org.mapstruct.Mapper;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.entity.Book;

@Mapper
public interface BookMapper {
	
	
	BookDTO toDTO(Book book);
	
	Book toEntity(BookDTO bookDTO);
	
}
