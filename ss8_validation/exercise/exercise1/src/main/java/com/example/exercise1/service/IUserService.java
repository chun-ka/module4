package com.example.exercise1.service;

import com.example.exercise1.model.User;

import java.util.Optional;


public interface IUserService {
    Iterable<User> findAll();

    Optional<User> findById(int id);

    void save(User user);

    void remove(int id);
}
