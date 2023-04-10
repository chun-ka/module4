package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IBookService {
    Iterable<Book> findAll();

    Optional<Book> findById(int id);

    void save(Book book);

    void remove(int id);



}
