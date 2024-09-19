package com.example.front_buhg.controller;

import com.example.front_buhg.model.Product;
import com.example.front_buhg.service.ProductApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductApi productApi;

    @GetMapping
    public String getAllProducts(Model model) {
        Product[] products = productApi.getAll();
        model.addAttribute("products", products);
        return "products/products";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        Product product = productApi.getById(id);
        model.addAttribute("product", product);
        return "products/product";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "products/createProduct";
    }

    @PostMapping("/create")
    public String saveProduct(Product product) {
        productApi.save(product);
        return "redirect:/products";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, Product product) {
        productApi.update(product, id);
        return "redirect:/products";

    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productApi.delete(id);
        return "redirect:/products";
    }
}
