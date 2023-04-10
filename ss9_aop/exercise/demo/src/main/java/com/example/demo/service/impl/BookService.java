package com.example.demo.service.impl;

import com.example.demo.model.Book;
import com.example.demo.reposotory.IBookReposotory;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookReposotory iBookReposotory;

    @Override
    public Iterable<Book> findAll() {
        return iBookReposotory.findAll();
    }

    @Override
    public Optional<Book> findById(int id) {
        return iBookReposotory.findById(id);
    }

    @Override
    public void save(Book book) {
        iBookReposotory.save(book);
    }

    @Override
    public void remove(int id) {

    }

}
