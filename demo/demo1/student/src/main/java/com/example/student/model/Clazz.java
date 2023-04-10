package com.example.student.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String clazzName;



    public Clazz() {
    }

    public Clazz(int id, String name) {
        this.id = id;
        this.clazzName = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String name) {
        this.clazzName = name;
    }
}
