package com.example.controller;

import com.example.dto.QuestionContentDto;
import com.example.model.QuestionContent;
import com.example.model.QuestionType;
import com.example.service.IQuestionContentService;
import com.example.service.IQuestionTypeService;
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
@RequestMapping("question")

public class QuestionContentController {
    @Autowired
    private IQuestionContentService iQuestionContentService;
    @Autowired
    private IQuestionTypeService iQuestionTypeService;

    @GetMapping("")
    public String showList(Model model, @PageableDefault(page = 0, value = 5) Pageable pageable, @RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "") String questionTypeId) {
        Page<QuestionContent> questionContentList = iQuestionContentService.search(pageable, title, questionTypeId);
        model.addAttribute("questionTypeList", iQuestionTypeService.findAll());
        model.addAttribute("questionContentList", questionContentList);
        model.addAttribute("title", title);
        model.addAttribute("questionTypeId", questionTypeId);
        return "question/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        List<QuestionType> questionTypeList = iQuestionTypeService.findAll();
        model.addAttribute("questionContentDto", new QuestionContentDto());
        model.addAttribute("questionTypeList", questionTypeList);
        return "question/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute QuestionContentDto questionContentDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("questionTypeList", iQuestionTypeService.findAll());
            return "question/create";
        }
        QuestionContent questionContent = new QuestionContent();
        BeanUtils.copyProperties(questionContentDto, questionContent);

        iQuestionContentService.save(questionContent);
        redirectAttributes.addFlashAttribute("mess", "thêm thành công");
        return "redirect:/question";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        QuestionContent questionContent = iQuestionContentService.findById(id).get();
        QuestionContentDto questionContentDto = new QuestionContentDto();
        BeanUtils.copyProperties(questionContent, questionContentDto);
        model.addAttribute("questionContentDto", questionContentDto);
        model.addAttribute("questionTypeList", iQuestionTypeService.findAll());
        return "question/edit";
    }

    @PostMapping("/edit")
    public String edit(QuestionContentDto questionContentDto, RedirectAttributes redirectAttributes) {
        QuestionContent questionContent = new QuestionContent();
        BeanUtils.copyProperties(questionContentDto, questionContent);
        iQuestionContentService.save(questionContent);
        redirectAttributes.addFlashAttribute("mess", "sửa thành công");
        return "redirect:/question";
    }

    @PostMapping("/delete")
    public String delete(int deleteId, RedirectAttributes redirectAttributes) {
        iQuestionContentService.delete(deleteId);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/question";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        QuestionContent questionContent = iQuestionContentService.findById(id).get();
        model.addAttribute("questionContent", questionContent);
        return "question/view";
    }
}