package com.spring.mongodb.reactive.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Tutorial {

  @Id
  private String id;

  private String title;

  private String description;

  private boolean published;

  public Tutorial() {

  }
}