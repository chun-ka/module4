package com.example.exercise1.reposotory;

import com.example.exercise1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserReposotory extends JpaRepository<User,Integer> {
}
