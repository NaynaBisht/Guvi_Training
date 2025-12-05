package com.microservices.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document
@Data
public class Quiz {

	@Id
	private Integer id;
	private String title;

	private List<Question> questions;
}
