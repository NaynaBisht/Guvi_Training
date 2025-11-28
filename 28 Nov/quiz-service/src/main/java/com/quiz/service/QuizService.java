package com.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.dao.QuizDao;
import com.quiz.feign.QuizInterface;
import com.quiz.model.Question;
import com.quiz.model.QuestionWrapper;
import com.quiz.model.Quiz;
import com.quiz.model.Response;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuizInterface quizInterface;

//	@Autowired
//	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String categoryName, int numQuestions, String title) {
		List<QuestionWrapper> questions = quizInterface.getQuestionsForQuiz(categoryName, numQuestions).getBody();
		
		List<Integer> questionIds = questions.stream()
		        .map(QuestionWrapper::getId)
		        .toList();
		
		Quiz quiz = new Quiz();
		quiz.setQuestionIds(questionIds);
		quizDao.save(quiz);

		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizquestions(String id) {
		Quiz quiz = quizDao.findById(id).get();
		List<Integer> questionIds = quiz.getQuestionIds();
		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);

		return questions;
	}

	public ResponseEntity<Integer> calculateResult(String id, List<Response> responses) {

		ResponseEntity<Integer> score = quizInterface.getScore(responses);
		
		return score;
	}

}
