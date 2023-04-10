package com.codegym.repository.impl;

import com.codegym.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.codegym.repository.ICustomerRepository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository {

    private static List<Customer> customerList =new ArrayList<>();
    static {
        customerList.add(new Customer(1,"Trung","trungnoo196@gmail.com","da nang"));
        customerList.add(new Customer(2,"Trung2","trungnoo196@gmail.com","da nang"));
        customerList.add(new Customer(3,"Trung3","trungnoo196@gmail.com","da nang"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }
}
