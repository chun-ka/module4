package com.codegym.controller;

import com.codegym.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    private ICaculatorService caculatorService;
    @GetMapping("")
    public String caculator(){
        return "index";
    }
    @PostMapping ("")
    public String caculator(@RequestParam int number1, int number2, Character calculate, Model model){
        String result=caculatorService.caculator(number1,number2,calculate);
        model.addAttribute("result",String.format("%s %s %s = %s",number1,calculate,number2,result));
        return "index";
    }
}
