package com.example.exercise1.controller;

import com.example.exercise1.model.Blog;
import com.example.exercise1.model.Category;
import com.example.exercise1.service.IBlogService;
import com.example.exercise1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.domain.Pageable;

import java.util.Comparator;
import java.util.List;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "") String search, @PageableDefault(page = 0,size = 2)Pageable pageable, Model model) {
        //Page<Blog> blogList = iBlogService.findBlogByTitleContainingOrAuthorContainingOrderByTitle(search,pageable);
       // Iterable<Blog> blogList = iBlogService.findAll(pageable);
        Page<Blog> blogList=iBlogService.searchTitleAndAuthor(search,pageable);

        model.addAttribute("blogList", blogList);
        model.addAttribute("search", search);
        return "blog/list";
    }

    @GetMapping("/create")
    public String create(Model model,Pageable pageable) {
        model.addAttribute("blog", new Blog());
        Iterable<Category> categoryList=iCategoryService.findAll(pageable);
        model.addAttribute("categoryList", categoryList);

        return "blog/create";
    }

    @PostMapping("/create")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "thêm thành công");
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model,Pageable pageable) {
        Blog blog = iBlogService.findById(id).get();
        model.addAttribute("blog", blog);
        Iterable<Category> categoryList=iCategoryService.findAll(pageable);
        model.addAttribute("categoryList", categoryList);
        return "blog/edit";
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
        return "blog/delete";
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
        return "blog/view";
    }
}
