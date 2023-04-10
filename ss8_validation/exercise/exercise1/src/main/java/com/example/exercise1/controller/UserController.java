package com.example.exercise1.controller;

import com.example.exercise1.dto.UserDto;
import com.example.exercise1.model.User;
import com.example.exercise1.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String showList(Model model) {
        Iterable<User> userList=iUserService.findAll();
        model.addAttribute("userList",userList);
        return "user/list";
    }
    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasErrors()) {
            return "user/create";
        }
        User user=new User();
        BeanUtils.copyProperties(userDto,user);
        iUserService.save(user);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/user";
    }
}
