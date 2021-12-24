package com.jikim.jpa.bookmanager.service;

import com.jikim.jpa.bookmanager.domain.User;
import com.jikim.jpa.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class UserService {

    @Autowired
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    // 비영속 상태
    @Transactional
    public void put() {
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@fastcampus.com");
        // 가비지 컬렉터로 사라지는 데이터 -> 아래 영속화로 해결

        // 영속화
        em.persist(user);
        em.detach(user);

        user.setName("newUserAfterPersist");
        // -> 영속화된 상태에서는 변경이 일어남 (detach)
        // detach가 들어가면 merge, flush 후에 반영
        em.merge(user);
        em.flush();
        em.clear(); // 준영속 상태로 변경

        User user1 = userRepository.findById(1L).get();
        em.remove(user1);

        // remove 후 merge 불가
//        user1.setName("marrrrtin");
//        em.merge(user1);
    }

}