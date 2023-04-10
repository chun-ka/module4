package com.codegym.controller;

import com.codegym.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ConvertController {
    @Autowired
    private ConvertService convertService;

    @GetMapping("")
    public String convert() {
        return "index";
    }

    @PostMapping("")
    public String convert(Model model, double usd) {
        double vnd = convertService.convert(usd);
        model.addAttribute("vnd", String.format("%s usd có giá trị là %s vnd:", usd, vnd));
        return "index";
    }
}
