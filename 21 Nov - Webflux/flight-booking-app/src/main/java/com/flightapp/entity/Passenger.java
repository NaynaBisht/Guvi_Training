package com.flightapp.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Passenger {

    @NotBlank
    private String passengerName;

    @NotNull
    private int age;

    @NotBlank
    @Pattern(regexp = "Male|Female|Other")
    private String gender;

    @NotBlank
    @Pattern(regexp = "^[A-Z]\\d{1,2}$")
    private String seatNum;

    @NotBlank
    @Pattern(regexp = "Veg|Non-Veg|No-Meal")
    private String mealPref;
}
