package com.example.bookstoreapi.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/search")
	public List<Book> searchBooks(@RequestParam(required = false) String title,
								   @RequestParam (required = false) String author){
		if (title!=null && author!=null) {
			return bookRepository.findByTitleAndAuthor(title, author);
		}
		else if(title!=null) {
			return bookRepository.findByTitle(title);
		}
		else if(author!=null) {
			return bookRepository.findByAuthor(author);
		}
		else {
			return bookRepository.findAll();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBooksById(@PathVariable Long id){
		Optional<Book> book = bookRepository.findById(id);
		return book.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		Book savedBook = bookRepository.save(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
		if(!bookRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		book.setId(id);
		Book updatedBook = bookRepository.save(book);
		return ResponseEntity.ok(updatedBook);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id){
		if(!bookRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		bookRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
