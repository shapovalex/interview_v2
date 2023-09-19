package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationServiceTest {
    @Test
    void test1() {
        CalculationService calculationService = new CalculationService();
        for (int i = 0; i < 100; i++) {
            calculationService.doOperation();
        }
        assertEquals(100, calculationService.getCalculationCount());
    }
}