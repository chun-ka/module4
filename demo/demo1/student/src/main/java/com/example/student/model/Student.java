package com.example.student.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dayOfBirth;
    @ManyToOne
    @JoinColumn(name = "clazz_id",referencedColumnName = "id")
    private Clazz clazz;

    public Student(int id, String name, String dayOfBirth, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.clazz = clazz;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
