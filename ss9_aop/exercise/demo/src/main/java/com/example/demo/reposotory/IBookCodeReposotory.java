package com.example.demo.reposotory;

import com.example.demo.model.BookCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IBookCodeReposotory extends JpaRepository<BookCode, Integer> {
//    @Modifying
//    @Transactional
//    @Query(value = "SELECT code FROM book.book_code;", nativeQuery = true)
//    List<Integer> showCode();
}
