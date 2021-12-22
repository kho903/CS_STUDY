package com.jikim.jpa.bookmanager.repository;

import com.jikim.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

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

    @Test
    void flushTest() {
//        userRepository.save(new User("new Martin", "martin@naver.com"));
//        userRepository.flush();
        userRepository.saveAndFlush(new User("new Martin", "martin@naver.com"));

        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void countTest() {
        long count = userRepository.count();
        System.out.println("count = " + count);

        boolean exists = userRepository.existsById(1L);
        System.out.println("exists = " + exists);
    }

    @Test
    void deleteTest() {
//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
        userRepository.deleteById(1L);
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void deleteAllTest() {
//        userRepository.deleteAll();
//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
//        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
        userRepository.deleteAllInBatch();
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void pagingTest() {
        Page<User> users = userRepository.findAll(PageRequest.of(0, 3));

        System.out.println("users = " + users);
        System.out.println("users.getTotalElements() = " + users.getTotalElements());
        System.out.println("users.getTotalPages() = " + users.getTotalPages());
        System.out.println("users.getNumberOfElements() = " + users.getNumberOfElements());
        System.out.println("users.getSort() = " + users.getSort());
        System.out.println("users.getSize() = " + users.getSize());

        users.getContent().forEach(System.out::println);
    }

    @Test
    void queryByExampleTest() {
//        ExampleMatcher matcher = ExampleMatcher.matching()
////                .withIgnorePaths("name")
//                .withMatcher("email", endsWith());
//        Example<User> example = Example.of(new User("martin", "fastcampus.com"), matcher);

        User user = new User();
        user.setEmail("slow");

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
        Example<User> example = Example.of(user, matcher);

        userRepository.findAll(example).forEach(System.out::println);
    }

    @Test
    void crud() {
        userRepository.save(new User("david", "david@fastcampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-updated@fastcampus.com");

        userRepository.save(user);
    }

    // QueryMethod Test
    @Test
    void selectTest() {
        System.out.println(userRepository.findByName("dennis"));

        System.out.println("findByEmail : "  + userRepository.findByEmail("martin@fastcampus.com"));
        System.out.println("getByEmail : "  + userRepository.getByEmail("martin@fastcampus.com"));
        System.out.println("readByEmail : "  + userRepository.readByEmail("martin@fastcampus.com"));
        System.out.println("queryByEmail : "  + userRepository.queryByEmail("martin@fastcampus.com"));
        System.out.println("searchByEmail : "  + userRepository.searchByEmail("martin@fastcampus.com"));
        System.out.println("streamByEmail : "  + userRepository.streamByEmail("martin@fastcampus.com"));
        System.out.println("findUserByEmail : "  + userRepository.findUserByEmail("martin@fastcampus.com"));

        System.out.println("findSomethingByEmail : "  + userRepository.findSomethingByEmail("martin@fastcampus.com"));

        System.out.println("findTop2ByName : " + userRepository.findTop2ByName("martin"));
        System.out.println("findFirst2ByName : " + userRepository.findFirst2ByName("martin"));

        // 없는 키워드는 무시! 그냥 findByName과 같이 동작
        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));
    }

    @Test
    void queryMethodTest() {
        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@fastcampus.com", "martin"));
        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@fastcampus.com", "dennis"));

        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));

        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));

        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));
    }
}