package com.chubb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chubb.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
	List<Tutorial> findByPublished(boolean published);
	List<Tutorial> findByTitleContaining(String title);
}
