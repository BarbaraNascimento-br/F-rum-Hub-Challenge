package com.alura.ForumHub.repository;

import com.alura.ForumHub.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
