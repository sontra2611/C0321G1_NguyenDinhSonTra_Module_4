package com.codegym.controller;

import com.codegym.model.bean.Dictionary;
import com.codegym.model.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/search")
    public String search(){
        return "index";
    }

    @PostMapping("/result")
    public String result(@RequestParam String eng, Model model) {
        List<Dictionary> dictionaryList = dictionaryService.findAll();
        for (int i = 0; i < dictionaryList.size(); i++){
            if ((eng.toLowerCase()).equals(dictionaryList.get(i).getEnglish())){
                model.addAttribute("vietnamese", dictionaryList.get(i).getVietnamese());
                model.addAttribute("english", eng);
                return "result";
            }
        }
        return "result";
    }
}
