package com.jikim.jpa.bookmanager.repository;

import com.jikim.jpa.bookmanager.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
