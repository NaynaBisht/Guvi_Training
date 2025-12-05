package com.chubb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chubb.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
  List<Tag> findTagsByTutorialsId(Long tutorialId);
}
