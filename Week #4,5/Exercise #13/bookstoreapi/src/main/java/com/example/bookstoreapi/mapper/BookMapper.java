package com.example.bookstoreapi.mapper;

import org.mapstruct.Mapper;

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.entity.Book;

@Mapper
public interface BookMapper {
	
	BookDTO toDTO(Book book);
	
	Book toEntity(BookDTO bookDTO);
	
	public static Book convertToBook(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        }
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        return book;
    }

    public static BookDTO convertToBookDTO(Book book) {
        if (book == null) {
            return null;
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        return bookDTO;
    }
	
}
