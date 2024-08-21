package com.example.bookstoreapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Optional<Book> getBookById(Long id){
		return bookRepository.findById(id);
	}
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Optional<Book> updateBook(Long id,Book book){
		if(bookRepository.existsById(id)) {
			book.setId(id);
			return Optional.of(bookRepository.save(book));
		}
		return Optional.empty();
	}
	
	public boolean deleteBook(Long id) {
		if(bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
