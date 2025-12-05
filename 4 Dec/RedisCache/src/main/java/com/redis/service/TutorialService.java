package com.redis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import com.redis.model.Tutorial;
import com.redis.repository.TutorialRepository;

@Service
public class TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    // ----------- GET ALL (cached) -----------
    @Cacheable(value = "tutorials", key = "'all'")
    public List<Tutorial> findAll() {
        delay();
        return tutorialRepository.findAll();
    }

    // ----------- SEARCH BY TITLE (cached) -----------
    @Cacheable(value = "tutorials", key = "#title")
    public List<Tutorial> findByTitleContaining(String title) {
        delay();
        return tutorialRepository.findByTitleContaining(title);
    }

    // ----------- GET BY ID (cached) -----------
    @Cacheable(value = "tutorial", key = "#id")
    public Optional<Tutorial> findById(String id) {
        delay();
        return tutorialRepository.findById(id);
    }

    // ----------- GET PUBLISHED (cached) -----------
    @Cacheable(value = "published_tutorials", key = "#isPublished")
    public List<Tutorial> findByPublished(boolean isPublished) {
        delay();
        return tutorialRepository.findByPublished(isPublished);
    }

    // Artificial delay for demo
    private void delay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {}
    }
}
