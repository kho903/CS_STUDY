package com.jikim.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void test() {
        User user = new User();
        user.setEmail("gmldnr2222@naver.com");
        user.setName("Kim");

        // @AllArgsConstructor : 모든 인자 포함 생성자
        User user1 = new User(null, "Lee", "a@a.com", LocalDateTime.now(), LocalDateTime.now());
        // @RequiredArgsConstructor : @NonNull 인자 포함 생성자
        User user2 = new User("Park", "b@b.com");

        // @Builder
        User user3 = User.builder()
                .name("kim")
                .email("gmldnr2222@naver.com")
                .build();

        System.out.println(">>> " + user);
    }
}
