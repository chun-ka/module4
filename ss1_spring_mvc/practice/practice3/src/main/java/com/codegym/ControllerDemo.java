package com.codegym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerDemo {
    @Autowired
    ServiceDemo serviceDemo;
   @GetMapping("")
    public String convert(){
       return "index";
   }
   @PostMapping("")
   public String convert(String word,Model model){
       String string=serviceDemo.convert(word);
       model.addAttribute("string",string);
        return "index";
   }
}
