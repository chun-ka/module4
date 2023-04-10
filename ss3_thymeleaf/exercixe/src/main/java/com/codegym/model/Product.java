package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String view;
    private String productName;

    public Product(int id, String name, double price, String view, String productName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.view = view;
        this.productName = productName;
    }

    public Product() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
