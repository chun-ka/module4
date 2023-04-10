package com.example.demo.service.impl;

import com.example.demo.model.BookCode;
import com.example.demo.reposotory.IBookCodeReposotory;
import com.example.demo.service.IBookCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCodeService implements IBookCodeService {
    @Autowired
    private IBookCodeReposotory iBookCodeReposotory;

    @Override
    public Iterable<BookCode> findAll() {
        return null;
    }

    @Override
    public Optional<BookCode> findById(int id) {
        return iBookCodeReposotory.findById(id);
    }

    @Override
    public void save(BookCode bookCode) {
        iBookCodeReposotory.save(bookCode);
    }

    @Override
    public void remove(int id) {

    }

}
