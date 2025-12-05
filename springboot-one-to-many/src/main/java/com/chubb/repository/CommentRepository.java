package com.chubb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chubb.model.Comment;

import jakarta.transaction.Transactional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findByTutorialId(Long postId);
	
	@Transactional
	List<Comment> deleteByTutorialId(long tutorialId);
}