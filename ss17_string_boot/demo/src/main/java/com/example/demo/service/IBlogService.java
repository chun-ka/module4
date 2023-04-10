package com.example.demo.service;


import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService extends IService<Blog> {
    List<Blog> findBlogByTitleContainingOrAuthorContainingOrderByTitle(String name);

}
