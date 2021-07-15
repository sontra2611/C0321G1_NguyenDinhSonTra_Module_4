package com.codegym.model.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImlp implements CalculatorService {

    @Override
    public float calculate(String firstOperand, String secondOperand, char operator) {
        switch (operator) {
            case '+':
                return Float.parseFloat(firstOperand) + Float.parseFloat(secondOperand);
            case '-':
                return Float.parseFloat(firstOperand) - Float.parseFloat(secondOperand);
            case '*':
                return Float.parseFloat(firstOperand) * Float.parseFloat(secondOperand);
            case '/':
                if (Float.parseFloat(secondOperand) != 0) {
                    return Float.parseFloat(firstOperand) / Float.parseFloat(secondOperand);
                } else {
                    throw new RuntimeException("Can't divide by zero");
                }
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
