package com.microservices.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservices.model.Question;

@Repository
public interface QuestionDao extends MongoRepository<Question, Integer> {

	List<Question> findByCategory(String category);

	@Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ ")
	List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
