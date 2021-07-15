package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpicesController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save(@RequestParam("spice") String[] spices, Model model) {
        model.addAttribute("spices", spices);
        return "save";
    }
}
