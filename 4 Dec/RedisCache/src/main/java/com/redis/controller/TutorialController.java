package com.redis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.redis.model.Tutorial;
import com.redis.repository.TutorialRepository;
import com.redis.service.TutorialService;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

    @Autowired
    private TutorialRepository tutorialRepository;

    @Autowired
    private TutorialService service;

    @PostMapping
    public Tutorial createTutorial(@RequestBody Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    @GetMapping
    public List<Tutorial> getAll(@RequestParam(required = false) String title) {

        if (title != null) {
            return service.findByTitleContaining(title); // cached
        }

        return service.findAll(); // cached
    }

    @GetMapping("/{id}")
    public Optional<Tutorial> getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Tutorial updateTutorial(@PathVariable String id, @RequestBody Tutorial tutorial) {
        return tutorialRepository.findById(id).map(t -> {
            t.setTitle(tutorial.getTitle());
            t.setDescription(tutorial.getDescription());
            t.setPublished(tutorial.isPublished());
            return tutorialRepository.save(t);
        }).orElseThrow(() -> new RuntimeException("Tutorial not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteTutorial(@PathVariable String id) {
        tutorialRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllTutorials() {
        tutorialRepository.deleteAll();
    }

    @GetMapping("/published")
    public List<Tutorial> getPublished() {
        return service.findByPublished(true);
    }
}
