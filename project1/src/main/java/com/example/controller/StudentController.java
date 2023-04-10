package com.example.controller;

import com.example.dto.StudentDto;
import com.example.model.Clazz;
import com.example.model.Student;
import com.example.service.IClazzService;
import com.example.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;
    @Autowired
    private IClazzService iClazzService;

    @GetMapping("")
    public String showList(Model model, @PageableDefault(page = 0, value = 2) Pageable pageable,@RequestParam(defaultValue = "") String name,@RequestParam(defaultValue = "") String code,
                           @RequestParam(defaultValue = "") String clazzId) {
        if (!clazzId.equals("")) {
            model.addAttribute("clazzId", Integer.parseInt(clazzId));
        }
        Page<Student> studentList = iStudentService.search(pageable,name,code,clazzId);
        model.addAttribute("clazzList",iClazzService.findAll());
        model.addAttribute("studentList", studentList);
        model.addAttribute("name", name);
        model.addAttribute("code", code);
        return "student/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        List<Clazz> clazzList = iClazzService.findAll();
        model.addAttribute("studentDto", new StudentDto());
        model.addAttribute("clazzList", clazzList);
        return "student/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute StudentDto studentDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("clazzList", iClazzService.findAll());
            return "student/create";
        }
        if (iStudentService.existsByCode(studentDto.getCode())){
            bindingResult.rejectValue("code","mã học sinh đã tồn tại","mã học sinh đã tồn tại");
            model.addAttribute("clazzList", iClazzService.findAll());
            return "student/create";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        iStudentService.save(student);
        redirectAttributes.addFlashAttribute("mess", "thêm thành công");
        return "redirect:/student";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model){
        Student student=iStudentService.findById(id).get();
        StudentDto studentDto=new StudentDto();
        BeanUtils.copyProperties(student,studentDto);
        model.addAttribute("studentDto",studentDto);
        model.addAttribute("clazzList", iClazzService.findAll());
        return "student/edit";
    }
    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute StudentDto studentDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("clazzList", iClazzService.findAll());
            return "student/create";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        iStudentService.save(student);
        redirectAttributes.addFlashAttribute("mess", "sửa thành công");
        return "redirect:/student";
    }
    @PostMapping("/delete")
    public String delete(int deleteId,RedirectAttributes redirectAttributes) {
        iStudentService.delete(deleteId);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/student";
    }
}
