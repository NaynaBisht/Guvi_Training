package com.loggingapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathCalculationTest {

    @Test
    public void testAdd() {
        MathOperation obj = new MathOperation();
        int i = 10, j = 20;
        int result = obj.add(i, j);
        assertEquals(30, result);
    }

    @Test
    public void testMultiplication() {
        MathOperation obj = new MathOperation();
        int result = obj.multiply(5, 4);
        assertEquals(20, result);
        assertNotNull(result);
    }
}
