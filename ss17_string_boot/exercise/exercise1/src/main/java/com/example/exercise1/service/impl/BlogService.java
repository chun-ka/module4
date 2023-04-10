package com.example.exercise1.service.impl;
import com.example.exercise1.model.Blog;
import com.example.exercise1.repository.IBlogRepository;
import com.example.exercise1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository ;

    @Override
    public Iterable<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
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
    public Page<Blog> findBlogByTitleContainingOrAuthorContainingOrderByTitle(String name, Pageable pageable) {
        return iBlogRepository.findBlogByTitleContainingOrAuthorContainingOrderByTitle(name,name,pageable);
    }

    @Override
    public Page<Blog> searchTitleAndAuthor(String name,Pageable pageable) {
        return iBlogRepository.searchTitleAndAuthor(name,name,name,pageable);
    }
}
