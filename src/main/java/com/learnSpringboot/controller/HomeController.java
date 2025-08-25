package com.learnSpringboot.controller;

import com.learnSpringboot.model.Product;
import com.learnSpringboot.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Product> products = productRepository.findAll(); // Fetch from MongoDB
        model.addAttribute("products", products);
        return "index"; // Thymeleaf template
    }
}
