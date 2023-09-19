package com.example;

public class CalculationService {
    private int calculationCount = 0;
    public void doOperation() {
        calculationCount++;
    }

    public int getCalculationCount() {
        return calculationCount;
    }
}
