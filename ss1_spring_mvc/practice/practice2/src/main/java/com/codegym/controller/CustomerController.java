package com.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.codegym.service.ICustomerService;

import javax.servlet.http.HttpServlet;

@Controller
public class CustomerController extends HttpServlet {
    @Autowired
    private ICustomerService customerService;//class tự tạo mới dùng được  @Autowired

    @RequestMapping("")
    public String showList(Model model) {
        model.addAttribute("customerList", customerService.findAll());
        return "customers/list";
    }

}
