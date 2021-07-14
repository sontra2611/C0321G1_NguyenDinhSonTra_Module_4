package com.codegym.controller;

import com.codegym.model.service.CurrencyConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConvertController {
    @Autowired
    CurrencyConvertService currencyConvertService;

    @GetMapping("/convert")
    public String index() {
        return "index";
    }

    @PostMapping("/result")
    public String result(@RequestParam String usd, String rate, Model model) {
        float result = currencyConvertService.convert(usd,rate);
        model.addAttribute("result", result);
        return "result";
    }
}
