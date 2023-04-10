package com.example.service.impl;


import com.example.model.Student;
import com.example.reposotory.IStudentReposotory;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentReposotory iStudentReposotory;

    @Override
    public List<Student> findAll() {
        return iStudentReposotory.findAll();
    }

    @Override
    public Optional<Student> findById(int id) {
        return iStudentReposotory.findById(id);
    }

    @Override
    public void save(Student student) {
        iStudentReposotory.save(student);
    }

    @Override
    public void remove(int id) {
        iStudentReposotory.deleteById(id);
    }

    @Override
    public Page<Student> search(Pageable pageable) {
        return iStudentReposotory.search(pageable);
    }

    @Override
    public void delete(int deleteId) {
        iStudentReposotory.delete(deleteId);
    }

    @Override
    public Page<Student> search(Pageable pageable, String name, String code, String clazzId) {
        return iStudentReposotory.search(pageable,name,code,clazzId);
    }

    @Override
    public boolean existsByCode(String code) {
        return iStudentReposotory.existsByCode(code);
    }
}
