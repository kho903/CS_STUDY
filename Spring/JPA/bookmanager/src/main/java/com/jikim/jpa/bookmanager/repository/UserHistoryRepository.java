package com.jikim.jpa.bookmanager.repository;

import com.jikim.jpa.bookmanager.domain.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
