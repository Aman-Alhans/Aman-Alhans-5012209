package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.entity.Book;


import com.example.bookstoreapi.metrics.CustomMetricsService;
import com.example.bookstoreapi.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
    private BookService bookService;
	@Autowired
    private CustomMetricsService customMetricsService;
	
	@GetMapping("/update-metric")
    public String updateMetric() {
        customMetricsService.incrementCustomMetric();
        return "Custom metric updated!";
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Page<EntityModel<Book>>> getAllBooks(Pageable pageable) {
        Page<Book> books = bookService.getAllBooks(pageable);
        Page<EntityModel<Book>> bookResources = books.map(book -> {
            EntityModel<Book> resource = EntityModel.of(book);
            WebMvcLinkBuilder selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(book.getId()));
            resource.add(selfLink.withSelfRel());
            return resource;
        });
        return ResponseEntity.ok(bookResources);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<EntityModel<Book>> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            EntityModel<Book> resource = EntityModel.of(book.get());
            WebMvcLinkBuilder selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(id));
            resource.add(selfLink.withSelfRel());
            return ResponseEntity.ok(resource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<EntityModel<Book>> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        EntityModel<Book> resource = EntityModel.of(createdBook);
        WebMvcLinkBuilder selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(createdBook.getId()));
        resource.add(selfLink.withSelfRel());
        return ResponseEntity.status(HttpStatus.CREATED).body(resource);
    }

    @PutMapping(value = "/{id}",
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<EntityModel<Book>> updateBook(@PathVariable Long id, @RequestBody Book book) {
        if (!bookService.getBookById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        book.setId(id);
        Book updatedBook = bookService.createBook(book);
        EntityModel<Book> resource = EntityModel.of(updatedBook);
        WebMvcLinkBuilder selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(updatedBook.getId()));
        resource.add(selfLink.withSelfRel());
        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (!bookService.getBookById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
