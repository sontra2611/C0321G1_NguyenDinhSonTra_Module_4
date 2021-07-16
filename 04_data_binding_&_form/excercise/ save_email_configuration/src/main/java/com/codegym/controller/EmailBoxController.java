package com.codegym.controller;

import com.codegym.model.bean.EmailBox;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailBoxController {

    @GetMapping("formUpdate")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("update", "emailBox", new EmailBox("Vietnamese","50", true, "Tra"));
        return modelAndView;
    }

    @PostMapping("update")
    public ModelAndView update(@ModelAttribute("emailBox") EmailBox emailBox) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("emailBox", emailBox);
        return modelAndView;
    }
}
