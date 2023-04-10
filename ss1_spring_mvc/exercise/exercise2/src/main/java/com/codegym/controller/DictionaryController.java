package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;
    @GetMapping("")
    public String translate() {
        return "index";
    }
    @PostMapping("")
    public String translate(Model model, String wordInput) {
        String word = dictionaryService.translate(wordInput);
        model.addAttribute("word",word);
        return "index";
    }

}




