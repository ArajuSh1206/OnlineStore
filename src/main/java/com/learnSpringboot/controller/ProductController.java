package com.learnSpringboot.controller;

import com.learnSpringboot.model.Product;
import com.learnSpringboot.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Home page - show all products
    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "index"; // index.html
    }

    // Products page - show latest to oldest
    @GetMapping("/products")
    public String products(Model model) {
        List<Product> products = productRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Product::getCreatedAt).reversed()) 

        model.addAttribute("products", products);
        return "products"; // products.html
    }
}
