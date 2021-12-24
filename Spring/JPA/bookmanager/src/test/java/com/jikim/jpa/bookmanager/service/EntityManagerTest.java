package com.jikim.jpa.bookmanager.service;

import com.jikim.jpa.bookmanager.domain.User;
import com.jikim.jpa.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class EntityManagerTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Test
    void entityManagerTest() {
        em.createQuery("select u from User u").getResultList().forEach(System.out::println);
    }

    @Test
    void cacheFindTest() {
//        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
//        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
//        System.out.println(userRepository.findByEmail("martin@fastcampus.com"));
//        System.out.println(userRepository.findById(2L).get());
//        System.out.println(userRepository.findById(2L).get());
//        System.out.println(userRepository.findById(2L).get());

        userRepository.deleteById(1L);
    }

    @Test
    void cacheFindTest2() {
        User user = userRepository.findById(1L).get();
        user.setName("marrrtin");
        userRepository.save(user);

        user.setEmail("marrrtin@fastcampus.com");
        userRepository.save(user);
//        userRepository.flush();

        // 영속성 컨텍스트가 가지고 있는 값과
        // DB의 값에 차이가 발생
        System.out.println("11111 userRepository.findById(1L).get() = " + userRepository.findById(1L).get());
        userRepository.flush();

        System.out.println("22222 userRepository.findById(1L).get() = " + userRepository.findById(1L).get());
    }

    @Test
    void cacheFindTest3() {
        User user = userRepository.findById(1L).get();
        user.setName("marrrtin");
        userRepository.save(user);

        user.setEmail("marrrtin@fastcampus.com");
        userRepository.save(user);

        // update 쿼리 후 select
        System.out.println("userRepository.findAll() = " + userRepository.findAll());
    }
}
