package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iCustomerRepository;

    @Override
    public List<Product> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iCustomerRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        iCustomerRepository.update(id, product);
    }

    @Override
    public void remove(int id) {
        iCustomerRepository.remove(id);
    }

    @Override
    public List<Product> search(String search) {
        return iCustomerRepository.search(search);
    }
}
