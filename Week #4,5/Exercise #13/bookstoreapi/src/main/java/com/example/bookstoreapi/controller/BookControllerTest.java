package com.example.bookstoreapi.controller;


import com.example.bookstoreapi.entity.Book;
import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.service.BookService;
import com.example.bookstoreapi.mapper.BookMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void testCreateBook() throws Exception {
        
        BookDTO bookDTO = new BookDTO(1L, "Sample Book", "Sample Author",1234D);

        Book book = BookMapper.convertToBook(bookDTO);

        given(bookService.createBook(book)).willReturn(book);

        mockMvc.perform(post("/books")
                .contentType("application/json")
                .content(new ObjectMapper().writeValueAsString(bookDTO)))
                .andExpect(status().isCreated());
    }
}
