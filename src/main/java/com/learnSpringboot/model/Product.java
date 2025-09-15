package com.learnSpringboot.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private Double price;
    private String image;

    @CreatedDate
    @Field("createdAt")
    private LocalDateTime createdAt;

    public Product() {}

    public Product(String id, String name, Double price, String image, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.createdAt = createdAt;
    }

    // getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
