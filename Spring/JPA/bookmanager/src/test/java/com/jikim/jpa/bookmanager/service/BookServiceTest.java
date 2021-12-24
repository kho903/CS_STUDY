package com.jikim.jpa.bookmanager.service;

import com.jikim.jpa.bookmanager.repository.AuthorRepository;
import com.jikim.jpa.bookmanager.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void transactionTest() {
        bookService.putBookAndAuthor();

        System.out.println("books : " + bookRepository.findAll());
        System.out.println("authors : " + bookRepository.findAll());
    }
}