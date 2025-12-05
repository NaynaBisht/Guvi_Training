package com.microservices.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservices.model.Quiz;

public interface QuizDao extends MongoRepository<Quiz, Integer> {

}
