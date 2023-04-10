package com.example.exercise1.service.impl;

import com.example.exercise1.model.User;
import com.example.exercise1.reposotory.IUserReposotory;
import com.example.exercise1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserReposotory iUserReposotory;

    @Override
    public Iterable<User> findAll() {
        return iUserReposotory.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return iUserReposotory.findById(id);
    }

    @Override
    public void save(User user) {
        iUserReposotory.save(user);
    }

    @Override
    public void remove(int id) {
        iUserReposotory.deleteById(id);
    }
}
