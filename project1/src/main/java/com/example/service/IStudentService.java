package com.example.service;


import com.example.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IStudentService extends IService<Student> {
    Page<Student> search(Pageable pageable);
    void delete(int deleteId);
    Page<Student> search(Pageable pageable,String name,String code,String clazzId);
    boolean existsByCode(String code);

}
