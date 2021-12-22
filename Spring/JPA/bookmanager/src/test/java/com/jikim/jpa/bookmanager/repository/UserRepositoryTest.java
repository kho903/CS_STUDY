package com.jikim.jpa.bookmanager.repository;

import com.jikim.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findTest() {
//        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));

        users.forEach(System.out::println);
    }

    @Test
    void saveTest() {
        User user1 = new User("jack", "jack@naver.com");
        User user2 = new User("steve", "steve@naver.com");

        userRepository.save(user1);
//        userRepository.saveAll(Lists.newArrayList(user1, user2));

        List<User> users = userRepository.findAll();

        users.forEach(System.out::println);
    }

    @Test
//    @Transactional
    void getTest() {
//        User user = userRepository.getOne(1L);
        User user = userRepository.findById(1L).orElse(null);

        System.out.println("user = " + user);
    }
}