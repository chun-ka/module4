package com.example.demo.reposotory;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IBookReposotory extends JpaRepository<Book,Integer> {
//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE `book`.`book` SET `amount` = `amount`-1 WHERE `id` = :id", nativeQuery = true)
//    void removeById(@Param("id") int id);
//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE `book`.`book` SET `amount` = `amount`+1 WHERE `id` = :id", nativeQuery = true)
//    void addById(@Param("id") int id);
}

