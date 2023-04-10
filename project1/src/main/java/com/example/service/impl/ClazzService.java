package com.example.service.impl;

import com.example.model.Clazz;
import com.example.reposotory.IClazzReposotory;
import com.example.service.IClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClazzService implements IClazzService {
    @Autowired
    private IClazzReposotory iClazzReposotory;
    @Override
    public List<Clazz> findAll() {
        return iClazzReposotory.findAll();
    }

    @Override
    public Optional<Clazz> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Clazz clazz) {

    }

    @Override
    public void remove(int id) {

    }
}
