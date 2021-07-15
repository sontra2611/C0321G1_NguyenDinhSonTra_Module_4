package com.codegym.controller;

import com.codegym.model.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/")
    public String calculator() {
        return "index";
    }

    @PostMapping("/calculate")
    public String result(@RequestParam("firstOperand") String firstOperand, @RequestParam("secondOperand") String secondOperand, @RequestParam("operator") char operator, Model model) throws RuntimeException {
        model.addAttribute("firstOperand", firstOperand);
        model.addAttribute("secondOperand", secondOperand);
        model.addAttribute("operator", operator);

        try {
            float result = calculatorService.calculate(firstOperand, secondOperand, operator);
            model.addAttribute("result", result);
        } catch (RuntimeException exception) {
            model.addAttribute("message", exception.getMessage());
        }
        return "index";
    }
}
