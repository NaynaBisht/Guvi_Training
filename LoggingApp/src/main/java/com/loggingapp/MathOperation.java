package com.loggingapp;

public class MathOperation {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public boolean validateName(String name) {
        return name != null && name.length() > 2;
    }
}
