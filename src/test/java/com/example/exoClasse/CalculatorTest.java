package com.example.exoClasse;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.example.exoClasse.service.Calculator;

@RunWith( JUnit4.class )
public class CalculatorTest {

    @Test
    @DisplayName("Simple multiplication should work")
    public void testMultiply() {
    	Calculator calculator;
    	calculator = new Calculator();
        assertEquals(20, calculator.multiply(4, 5),
            "Regular multiplication should work");
    }

}
