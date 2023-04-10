package com.example.exercise1.repository;
import com.example.exercise1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findBlogByTitleContainingOrAuthorContainingOrderByTitle(String title, String author, Pageable pageable);
    @Query(value = "select b.* from blog b join category c on b.category_id=c.id where b.title like concat('%',:title,'%')" +
            " or b.author like concat('%',:author,'%')  or c.name like concat('%',:name,'%')  order by date ",
            countQuery ="select b.* from blog b join category c on b.category_id=c.id where b.title like concat('%',:title,'%') " +
                    "or b.author like concat('%',:author,'%') or c.name like concat('%',:name,'%')  order by date ",nativeQuery = true)
    Page<Blog> searchTitleAndAuthor(@Param("title") String title, @Param("author")String author,@Param("name")String name, Pageable pageable);
}
