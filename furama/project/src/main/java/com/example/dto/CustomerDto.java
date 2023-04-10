package com.example.dto;


import com.example.model.customer.CustomerType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public class CustomerDto {

    private int id;
    @NotBlank(message ="Tên không được chứa toàn khoảng trắng")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$",message = "Tên không đúng định dạng")
    private String name;
    @NotEmpty(message = "Không được bỏ trống")
    private String dateOfBirth;
    @NotEmpty(message = "Không được bỏ trống")
    private String gender;
    @Pattern(regexp = "^[0-9]{9}|[0-9]{12}$",message = "chứa 9 hoặc 12 số")
    private String idCard;
    @Pattern(regexp = "^0[0-9]{9}",message = "Sdt không đúng định dạng")
    private String phoneNumber;
    @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$",message = "Địa chỉ email không đúng định dạng")
    private String email;
    private String address;


    private CustomerType customerType;

    public CustomerDto() {
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

}