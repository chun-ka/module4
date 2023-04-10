package com.example.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IService<T>{
    Page<T> findAll(Pageable pageable);
    List<T> findAll();

    Optional<T> findById(int id);

    void save(T t);

    void remove(int id);
}
