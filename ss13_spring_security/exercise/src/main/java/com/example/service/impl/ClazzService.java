package com.example.service.impl;

import com.example.model.Clazz;
import com.example.reposotory.IClazzRepository;
import com.example.service.IClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClazzService implements IClazzService {
    @Autowired
    private IClazzRepository iClazzRepository;

    @Override
    public Iterable<Clazz> findAll(Pageable pageable) {
        return iClazzRepository.findAll(pageable);
    }

    @Override
    public Optional<Clazz> findById(int id) {
        return iClazzRepository.findById(id);
    }

    @Override
    public void save(Clazz clazz) {
        iClazzRepository.save(clazz);
    }

    @Override
    public void remove(int id) {
        iClazzRepository.deleteById(id);
    }
}
