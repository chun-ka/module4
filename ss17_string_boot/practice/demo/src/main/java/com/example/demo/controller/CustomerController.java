package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller

public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/customer")
    public String showList(Model model) {
        model.addAttribute("customerList", iCustomerService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/create")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "thêm thành công");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Customer> customer = iCustomerService.findById(id);
        model.addAttribute("customer", customer.get());
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "sửa thành công");
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        Optional<Customer> customer = iCustomerService.findById(id);
        model.addAttribute("customer",customer.get());
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Customer customer,RedirectAttributes redirectAttributes) {
        iCustomerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("mess", "xóa thành công");
        return "redirect:/customer";
    }
}
