package com.example.dto;

import com.example.model.Clazz;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentDto implements Validator {
    private int id;
    private String name;
    private String dayOfBirth;
    private Clazz clazz;

    public StudentDto(int id, String name, String dayOfBirth, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.clazz = clazz;
    }

    public StudentDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDto studentDto=(StudentDto) target;
        if (!studentDto.getClazz().getClazzName().matches("(C0722G1)|(C0822G1)")){
            errors.rejectValue("clazzName","clazzName","Tên lớp không đúng");
        }
    }
}
