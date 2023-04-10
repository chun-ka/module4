package com.example.reposotory;

import com.example.model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClazzRepository extends JpaRepository<Clazz,Integer> {
}
