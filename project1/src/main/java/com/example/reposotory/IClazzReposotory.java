package com.example.reposotory;

import com.example.model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClazzReposotory extends JpaRepository<Clazz,Integer> {
}
