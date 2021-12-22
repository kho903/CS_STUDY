package com.jikim.jpa.bookmanager.repository;

import com.jikim.jpa.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
