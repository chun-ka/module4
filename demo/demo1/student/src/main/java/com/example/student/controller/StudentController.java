package com.example.student.controller;

import com.example.student.dto.StudentDto;
import com.example.student.model.Student;
import com.example.student.service.IClazzService;
import com.example.student.service.IStudentService;
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

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;
    @Autowired
    private IClazzService iClazzService;
    @GetMapping("")
    public String showList(Model model, Pageable pageable){
        Iterable<Student> studentList=iStudentService.findAll(pageable);
        model.addAttribute("studentList",studentList);
        return "student/list";
    }
    @GetMapping("/create")
    public String create(Model model,Pageable pageable){
        model.addAttribute("studentDto",new StudentDto());
        model.addAttribute("clazzList",iClazzService.findAll(pageable));

        return "student/create";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute StudentDto studentDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model,
                         @PageableDefault(page = 0,size = 5) Pageable pageable){
        // new StudentDto().validate(studentDto,bindingResult);
        if (bindingResult.hasErrors()){
           model.addAttribute("clazzList",iClazzService.findAll(pageable));
            return "student/create";
        }
        Student student=new Student();
        BeanUtils.copyProperties(studentDto,student);
        iStudentService.save(student);
        redirectAttributes.addFlashAttribute("mess","Thêm thành công");
        return "redirect:/student";
    }
}
