package com.jikim.jpa.bookmanager.service;

import com.jikim.jpa.bookmanager.domain.Author;
import com.jikim.jpa.bookmanager.domain.Book;
import com.jikim.jpa.bookmanager.repository.AuthorRepository;
import com.jikim.jpa.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Transactional
    public void putBookAndAuthor() {
        Book book = new Book();
        book.setName("JPA");

        bookRepository.save(book);

        Author author = new Author();
        author.setName("martin");

        authorRepository.save(author);

        throw new RuntimeException("오류가 나서 DB Commit 발생 X");
    }
}