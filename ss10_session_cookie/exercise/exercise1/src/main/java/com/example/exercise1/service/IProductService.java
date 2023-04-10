package com.example.exercise1.service;


import com.example.exercise1.model.Product;

import java.util.Optional;


public interface IProductService {
    Iterable<Product> findAll( );

    Optional<Product> findById(int id);

    void save(Product product);

    void remove(int id);
}
