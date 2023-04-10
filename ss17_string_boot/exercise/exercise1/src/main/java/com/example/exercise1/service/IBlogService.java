package com.example.exercise1.service;


import com.example.exercise1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import java.util.List;

public interface IBlogService extends IService<Blog> {
    Page<Blog> findBlogByTitleContainingOrAuthorContainingOrderByTitle(String name, Pageable pageable);
    Page<Blog> searchTitleAndAuthor(String name, Pageable pageable);

}
