package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("categorys")
public class CategoryRestController {

        @Autowired
        private IBlogService iBlogService;
        @Autowired
        private ICategoryService iCategoryService;
        @GetMapping
        public ResponseEntity<Page<Category>> getList(@PageableDefault(page = 0,size = 2) Pageable pageable){
            Page<Category> categoryList=iCategoryService.findAll(pageable);
            if (categoryList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categoryList,HttpStatus.OK);
        }
        @PostMapping
        public ResponseEntity<Category> saveCategory(@RequestBody Category category){
            iCategoryService.save(category);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }


}
