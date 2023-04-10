package com.codegym.controller;

import com.codegym.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
   @GetMapping("")
    public String show(Model model){
       model.addAttribute("student",new Student());
       return "create";
   }

   @PostMapping("student")
    public String save(Model model,@ModelAttribute Student student){
       model.addAttribute("student",student);
       return "index";
   }
}
