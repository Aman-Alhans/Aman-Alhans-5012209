package com.example.bookstoreapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstoreapi.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByTitleAndAuthor(String title, String author);
}
