package com.example.service;


import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService extends IService<Blog> {
    Page<Blog> findByCategoryId(Pageable pageable,int id);
    List<Blog> searchTitleOrAuthorOrCategoryName(String name);
    List<Blog> findBlogByTitleContaining(String name);
    List<Blog> searchTitleOrAuthorOrCategoryName2(String name);

}
