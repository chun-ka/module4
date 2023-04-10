package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("blogs")
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

//    @GetMapping
//    public ResponseEntity<Page<Blog>> getList(@PageableDefault(page = 0, size = 10) Pageable pageable) {
//        Page<Blog> blogList = iBlogService.findAll(pageable);
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }

//    @GetMapping
//    public ResponseEntity<List<Blog>> getList() {
//        List<Blog> blogList = iBlogService.findAll();
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }
    @GetMapping
    public ResponseEntity<List<Blog>> getListBySearch(@RequestParam(defaultValue = "") String search) {
        List<Blog> blogList = iBlogService.searchTitleOrAuthorOrCategoryName(search);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/more")
    public ResponseEntity<List<Blog>> getListBySearch2(@RequestParam(defaultValue = "") String search) {
        List<Blog> blogList = iBlogService.searchTitleOrAuthorOrCategoryName2(search);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        blog.setCategory(iCategoryService.findById(blog.getCategory().getId()).get());
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> viewBlog(@PathVariable int id) {
        Blog blog = iBlogService.findById(id).get();

        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("category/{id}")
    public ResponseEntity<Page<Blog>> showBlogByCategory(@PathVariable int id, @PageableDefault(page = 0, size = 2) Pageable pageable) {
        Page<Blog> blogList = iBlogService.findByCategoryId(pageable, id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") int id) {
        Blog blog = iBlogService.findById(id).get();
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.remove(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> update(@RequestBody Blog blog, @PathVariable("id") int id) {
        Blog blog1 = iBlogService.findById(id).get();
        if (blog1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.save(blog);

        return new ResponseEntity<>(blog, HttpStatus.OK);

    }
}
