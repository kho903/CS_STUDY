package com.jikim.jpa.bookmanager.service;

import com.jikim.jpa.bookmanager.domain.Comment;
import com.jikim.jpa.bookmanager.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public void init() {
        for (int i = 0; i < 10; i++) {
            Comment comment = new Comment();
            comment.setComment("최고에요");

            commentRepository.save(comment);
        }
    }

    @Transactional(readOnly = true) // readOnly = true : dirty check X
    public void updateSomething() {
        List<Comment> comments = commentRepository.findAll();
        for (Comment comment : comments) {
            comment.setComment("별로에요");

//            commentRepository.save(comment); // save를 하지 않아도 update 됨 - dirty check
        }
    }

    @Transactional
    public void insertSomething() {
//        Comment comment = new Comment(); // dirty check의 대상 X
        Comment comment = commentRepository.findById(1L).get(); // dirty check의 대상
        comment.setComment("이건 뭐죠");

//        commentRepository.save(comment);
    }
}
