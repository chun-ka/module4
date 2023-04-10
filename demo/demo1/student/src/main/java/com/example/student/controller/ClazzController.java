package com.example.student.controller;

import com.example.student.dto.StudentDto;
import com.example.student.model.Clazz;
import com.example.student.model.Student;
import com.example.student.service.IClazzService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    private IClazzService iClazzService;
    @GetMapping("")
    public String showList(Model model, Pageable pageable){
        Iterable<Clazz> clazzList=iClazzService.findAll(pageable);
        model.addAttribute("clazzList",clazzList);
        return "clazz/list";
    }
    @GetMapping("/create")
    public String create(Model model,Pageable pageable){
        model.addAttribute("clazz",new Clazz());
        return "clazz/create";
    }
    @PostMapping("/create")
    public String create( Clazz clazz, RedirectAttributes redirectAttributes,Pageable pageable){
        iClazzService.save(clazz);
        redirectAttributes.addFlashAttribute("mess","Thêm thành công");
        return "redirect:/clazz";
    }
}
