package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "sh", 1000, "đẹp","honda"));
        productMap.put(2, new Product(2, "AB", 1000, "đẹp","honda"));
        productMap.put(3, new Product(3, "sirius", 1000, "đẹp","yamaha"));
        productMap.put(4, new Product(4, "winner", 1000, "đẹp","honda"));
        productMap.put(5, new Product(5, "excenter", 1000, "đẹp","yamaha"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product customer) {
        productMap.put(customer.getId(), customer);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product customer) {
        productMap.put(id, customer);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> search(String search) {
        List<Product> productList=findAll();
        List<Product> productList2=new ArrayList<>();
        for (Product product:productList){
           if (product.getName().contains(search)){
               productList2.add(product);
           }
       }
        return productList2;
    }
}
