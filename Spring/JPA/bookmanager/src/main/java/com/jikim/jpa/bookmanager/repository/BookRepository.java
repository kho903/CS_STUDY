package com.jikim.jpa.bookmanager.repository;

import com.jikim.jpa.bookmanager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
