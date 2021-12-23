package com.jikim.jpa.bookmanager.repository;

import com.jikim.jpa.bookmanager.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
