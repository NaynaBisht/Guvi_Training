package com.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MicroservicesArchitectureProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesArchitectureProjectApplication.class, args);
	}
}
