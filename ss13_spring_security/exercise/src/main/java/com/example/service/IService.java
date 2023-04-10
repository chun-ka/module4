package com.example.service;

import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IService<T> {
    Iterable<T> findAll(Pageable pageable);

    Optional<T> findById(int id);

    void save(T t);

    void remove(int id);
}

