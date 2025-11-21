package com.flightapp.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Document(collection = "flights")
public class Flight {

    @Id
    private String id;

    @NotBlank
    private String flightNumber;

    @NotBlank
    private String airlineName;

    @NotBlank
    private String departingAirport;

    @NotBlank
    private String arrivalAirport;

    @NotNull
    private LocalDateTime departureTime;

    @NotNull
    private LocalDateTime arrivalTime;

    @Min(100)
    private float price;

    @Min(5)
    private int totalSeats;

    @Min(0)
    private int availableSeats;
}
