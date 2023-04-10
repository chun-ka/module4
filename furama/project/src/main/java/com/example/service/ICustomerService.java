package com.example.service;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerService extends IService<Customer> {
    Page<Customer> search(String name,String email,String customerTypeId, Pageable pageable);
    List<Customer> showList();
}
