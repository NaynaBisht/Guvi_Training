package com.redis.model;

import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
public class Tutorial {

    @Id
    private String id; 

    private String title;
    private String description;
    private boolean published;
}
