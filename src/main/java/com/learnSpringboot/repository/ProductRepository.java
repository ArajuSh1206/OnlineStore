package com.learnSpringboot.repository;

import com.learnSpringboot.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
