package com.codegym.controller;

import com.codegym.model.Mailbox;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class MailboxController {

    @GetMapping("")
    public String showForm(Model model){
        List<String> languageList= Arrays.asList("English","Vietnamese","Japanese","Chinese");
        List<Integer> sizeList=Arrays.asList(5,10,15,25,50,100);
        model.addAttribute("maibox",new Mailbox());
        model.addAttribute("languageList",languageList);
        model.addAttribute("sizeList",sizeList);
        return "index";
    }
    @PostMapping("show")
    public String info(Model model, @ModelAttribute Mailbox mailbox){

        model.addAttribute("mailbox",mailbox);
        return "info";
    }
}
