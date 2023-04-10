package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/blog")
    public String showList(@RequestParam(defaultValue = "") String search, Model model) {
        List<Blog> blogList = iBlogService.findBlogByTitleContainingOrAuthorContainingOrderByTitle(search);
        model.addAttribute("blogList", blogList);
        model.addAttribute("search", search);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "thêm thành công");
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Blog blog = iBlogService.findById(id).get();
        model.addAttribute("blog", blog);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "sửa thành công");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        Blog blog = iBlogService.findById(id).get();
        model.addAttribute("blog", blog);
        return "/delete";
    }

    @PostMapping("/delete")
    public String remove(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("mess", "xóa thành công");
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        Blog blog = iBlogService.findById(id).get();
        model.addAttribute("blog", blog);
        return "/view";
    }
}
