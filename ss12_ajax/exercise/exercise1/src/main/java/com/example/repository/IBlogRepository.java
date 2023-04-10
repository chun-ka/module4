package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select b.* from blog b join category c on b.category_id=c.id where b.title like concat('%',:title,'%')" +
            " or b.author like concat('%',:author,'%')  or c.name like concat('%',:name,'%')  order by date limit 2 ",
            countQuery ="select b.* from blog b join category c on b.category_id=c.id where b.title like concat('%',:title,'%') " +
                    "or b.author like concat('%',:author,'%') or c.name like concat('%',:name,'%')   order by date limit 2 ;",nativeQuery = true)
    List<Blog> searchTitleOrAuthorOrCategoryName(@Param("title") String title, @Param("author")String author, @Param("name")String name);

    @Query(value = "select b.* from blog b join category c on b.category_id=c.id where b.title like concat('%',:title,'%')" +
            " or b.author like concat('%',:author,'%')  or c.name like concat('%',:name,'%')  order by date  ",
            countQuery ="select b.* from blog b join category c on b.category_id=c.id where b.title like concat('%',:title,'%') " +
                    "or b.author like concat('%',:author,'%') or c.name like concat('%',:name,'%')   order by date  ;",nativeQuery = true)
    List<Blog> searchTitleOrAuthorOrCategoryName2(@Param("title") String title, @Param("author")String author, @Param("name")String name);

    Page<Blog> findByCategoryId(Pageable pageable,int id);
    List<Blog> findBlogByTitleContaining(String name);
}
