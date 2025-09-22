package com.learnSpringboot.controller;

import com.learnSpringboot.model.Product;
import com.learnSpringboot.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String home(Model model, @RequestParam(value = "search", required = false) String search) {
        List<Product> products;
        
        if (search != null && !search.trim().isEmpty()) {
            products = productRepository.findByNameContainingIgnoreCase(search.trim());
            model.addAttribute("searchTerm", search);
        } else {
            products = productRepository.findAll();
        }
        
        model.addAttribute("products", products);
        return "index";
    }

    // Products page - show latest to oldest
    @GetMapping("/products")
    public String products(Model model, @RequestParam(value = "search", required = false) String search) {
        List<Product> products;
        
        if (search != null && !search.trim().isEmpty()) {
            products = productRepository.findByNameContainingIgnoreCase(search.trim())
                    .stream()
                    .sorted(Comparator.comparing(Product::getCreatedAt, 
                            Comparator.nullsLast(Comparator.naturalOrder())).reversed())
                    .collect(Collectors.toList());
            model.addAttribute("searchTerm", search);
        } else {
            products = productRepository.findAll()
                    .stream()
                    .sorted(Comparator.comparing(Product::getCreatedAt, 
                            Comparator.nullsLast(Comparator.naturalOrder())).reversed())
                    .collect(Collectors.toList());
        }

        model.addAttribute("products", products);
        return "products";
    }
}
