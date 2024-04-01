package com.loginAssessment.repo;

import com.loginAssessment.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT * FROM assessment.login WHERE user_id = :userId", nativeQuery = true)
    UserEntity findByUserId(Long userId);
}
