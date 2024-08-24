package com.example.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BookDTO {
	
	private Long id;
	
	@JsonProperty("book_title")
	private String title;
	
	private String author;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT, pattern = "#.##")
	private Double price;
	
	private String isbn;
}
