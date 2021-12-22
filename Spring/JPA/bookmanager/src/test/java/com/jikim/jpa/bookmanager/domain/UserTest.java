package com.jikim.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void test() {
        User user = new User();
        user.setName("Kim");
        user.setEmail("gmldnr2222@naver.com");

//        User user1 = new User(null, "Kim", "gmldnr2222@naver.com", LocalDateTime.now(), LocalDateTime.now(), null);
        User user2 = new User("Kim", "gmldnr2222@naver.com");

        System.out.println("user = " + user);

        // builder
        User user3 = User.builder().name("kim").email("gmldnr2222@naver.com").build();
        System.out.println("user3 = " + user3);
    }
}