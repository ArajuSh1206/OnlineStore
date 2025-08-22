package com.learnSpringboot.model;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private String image;

    public Product(Long id, String name, Double price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getPrice() { return price; }
    public String getImage() { return image; }
}
