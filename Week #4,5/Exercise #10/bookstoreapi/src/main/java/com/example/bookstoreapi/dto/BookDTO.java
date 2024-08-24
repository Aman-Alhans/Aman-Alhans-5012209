package com.example.bookstoreapi.dto;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BookDTO extends RepresentationModel<BookDTO> {
	
	private Long id;
	
	@JsonProperty("book_title")	
	private String title;
	
	private String author;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT, pattern = "#.##")
	private Double price;
	
	public BookDTO(Long id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
