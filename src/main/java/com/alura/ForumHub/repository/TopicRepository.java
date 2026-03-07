package com.alura.ForumHub.repository;

import com.alura.ForumHub.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<TopicEntity, Long> {
}
