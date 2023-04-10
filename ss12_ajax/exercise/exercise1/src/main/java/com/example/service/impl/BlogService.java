package com.example.service.impl;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.repository.IBlogRepository;
import com.example.repository.ICategoryRepository;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository ;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }


    @Override
    public Optional<Blog> findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        iBlogRepository.deleteById(id);
    }


    @Override
    public Page<Blog> findByCategoryId(Pageable pageable, int id) {
        return iBlogRepository.findByCategoryId(pageable,id);
    }

    @Override
    public List<Blog> searchTitleOrAuthorOrCategoryName(String name) {
        return iBlogRepository.searchTitleOrAuthorOrCategoryName(name,name,name);
    }

    @Override
    public List<Blog> findBlogByTitleContaining(String name) {
        return iBlogRepository.findBlogByTitleContaining(name);
    }
    @Override
    public List<Blog> searchTitleOrAuthorOrCategoryName2(String name) {
        return iBlogRepository.searchTitleOrAuthorOrCategoryName2(name,name,name);
    }
}
