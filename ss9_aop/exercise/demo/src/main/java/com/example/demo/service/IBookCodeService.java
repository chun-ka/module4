package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.BookCode;

import java.util.List;
import java.util.Optional;

public interface IBookCodeService {
    Iterable<BookCode> findAll();

    Optional<BookCode> findById(int id);

    void save(BookCode bookCode);

    void remove(int id);

}
