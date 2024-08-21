package com.example.bookstoreapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBooksById(@PathVariable("id") Long id){
		return bookService.getBookById(id)
				.map(book -> ResponseEntity.ok().body(book))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		Book createdBook = bookService.createBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book){
		return bookService.updateBook(id,book)
				.map(updatedBook -> ResponseEntity.ok().body(updatedBook))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id){
		if(bookService.deleteBook(id)) {
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
