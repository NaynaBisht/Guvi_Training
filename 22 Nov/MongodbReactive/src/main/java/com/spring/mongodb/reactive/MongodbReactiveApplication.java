package com.spring.mongodb.reactive;

import org.springframework.boot.SpringApplication;

import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableWebFlux
@SpringBootApplication
public class MongodbReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbReactiveApplication.class, args);
	}

}
