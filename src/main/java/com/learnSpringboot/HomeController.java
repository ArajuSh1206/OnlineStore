package com.learnSpringboot;

import com.learnSpringboot.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        // Temporary mock products
        List<Product> products = Arrays.asList(
                new Product(1L, "Coach Perfume", 25.0, "/images/CoachPerfume.jpg"),
                new Product(2L, "Coke Soda", 40.0, "/images/CokeSoda.jpg"),
                new Product(3L, "Nikon Camera", 30.0, "/images/NikonCamera.jpg"),
                new Product(4L, "Sae Brush & Paste", 15.0, "/images/SaeBrush&Paste.jpg"),
                new Product(5L, "Sae Face Cream", 20.0, "/images/SaeFaceCream.jpg")
        );

        model.addAttribute("products", products);

        // Return template name (without .html)
        return "index";
    }
}
