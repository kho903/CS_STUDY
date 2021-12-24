package com.jikim.jpa.bookmanager.service;

import com.jikim.jpa.bookmanager.domain.Author;
import com.jikim.jpa.bookmanager.domain.Book;
import com.jikim.jpa.bookmanager.repository.AuthorRepository;
import com.jikim.jpa.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

//    public void put() {
//        // 잘못된 사용법 -> putBookAndAuthor의 @Transactional 무시됨
//        this.putBookAndAuthor();
//    }

    @Transactional
    void putBookAndAuthor() {
        Book book = new Book();
        book.setName("JPA");

        bookRepository.save(book);

        Author author = new Author();
        author.setName("martin");

        authorRepository.save(author);

        throw new RuntimeException("오류가 나서 DB Commit 발생 X");
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void get(Long id) {
        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        Book book = bookRepository.findById(id).get();
        book.setName("change???");
        bookRepository.save(book);
    }
}
