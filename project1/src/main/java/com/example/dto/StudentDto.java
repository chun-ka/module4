package com.example.dto;


import com.example.model.Clazz;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class StudentDto {

    private int id;
    @NotBlank(message ="Tên không được chứa toàn khoảng trắng")
    @Pattern(regexp = "^HS-[0-9]{4}$",message = "Mã không đúng định dạng")
    private String code;
    @NotBlank(message ="Tên không được chứa toàn khoảng trắng")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$",message = "Tên không đúng định dạng")
    private String name;
    @NotEmpty(message = "Không được bỏ trống")
    private String dayOfBirth;
    @NotEmpty(message = "Không được bỏ trống")
    private String gender;
    @NotEmpty(message = "Không được bỏ trống")
    private String address;
    private Clazz clazz;
    private boolean flag=true;


    public StudentDto() {
    }

    public StudentDto(int id, String code, String name, String dayOfBirth, String gender, String address, Clazz clazz,boolean flag) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.address = address;
        this.clazz = clazz;
        this.flag=flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
