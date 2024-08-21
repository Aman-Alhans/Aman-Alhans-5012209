package com.example.bookstoreapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
	public ResponseEntity<List<Book>> searchBooks(@RequestParam(required = false) String title,
								   @RequestParam (required = false) String author){
		List<Book> books;
		if (title!=null && author!=null) {
			books = bookRepository.findByTitleAndAuthor(title, author);
		}
		else if(title!=null) {
			books = bookRepository.findByTitle(title);
		}
		else if(author!=null) {
			books = bookRepository.findByAuthor(author);
		}
		else {
			books = bookRepository.findAll();
		}
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", String.valueOf(books.size()));
        return ResponseEntity.ok().headers(headers).body(books);

	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBooksById(@PathVariable Long id){
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("X-Book-Found", "true");
            return ResponseEntity.ok().headers(headers).body(book.get());
        } 
		else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
	}
	
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		Book savedBook = bookRepository.save(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Book-ID", savedBook.getId().toString());
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(savedBook);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
		if(!bookRepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		book.setId(id);
		Book updatedBook = bookRepository.save(book);
		HttpHeaders headers = new HttpHeaders();
        headers.add("X-Update-Success", "true");
        return ResponseEntity.ok().headers(headers).body(updatedBook);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id){
		if(!bookRepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		bookRepository.deleteById(id);
		HttpHeaders headers = new HttpHeaders();
        headers.add("X-Deletion-Success", "true");
        return ResponseEntity.noContent().headers(headers).build();
	}
}
