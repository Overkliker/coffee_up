package com.example.front_buhg.controller;

import com.example.front_buhg.model.SaleItem;
import com.example.front_buhg.service.CoffeeShopApi;
import com.example.front_buhg.service.ProductApi;
import com.example.front_buhg.service.SaleApi;
import com.example.front_buhg.service.SaleItemApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/saleItems")
public class SaleItemController {

    @Autowired
    private SaleItemApi saleItemApi;

    @Autowired
    private SaleApi saleApi;

    @Autowired
    private ProductApi productApi;

    @GetMapping
    public String getAllProducts(Model model) {
        SaleItem[] products = saleItemApi.getAll();
        model.addAttribute("saleItems", products);
        return "saleItems/saleItems";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        SaleItem saleItem = saleItemApi.getById(id);
        model.addAttribute("saleItem", saleItem);

        model.addAttribute("sales", saleApi.getAll());
        model.addAttribute("products", productApi.getAll());
        return "saleItems/saleItem";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("saleItem", new SaleItem());

        model.addAttribute("sales", saleApi.getAll());
        model.addAttribute("products", productApi.getAll());
        return "saleItems/createSaleItem";
    }

    @PostMapping("/create")
    public String saveProduct(@RequestParam Long productId, @RequestParam Long saleId, SaleItem saleItem) {
        saleItem.setProduct(productApi.getById(productId));
        saleItem.setSale(saleApi.getById(saleId));
        saleItemApi.save(saleItem);
        return "redirect:/saleItems";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @RequestParam Long productId, @PathVariable Long saleId, SaleItem saleItem) {
        saleItem.setProduct(productApi.getById(productId));
        saleItem.setSale(saleApi.getById(saleId));
        saleItemApi.update(saleItem, id);
        return "redirect:/saleItems";

    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        saleItemApi.delete(id);
        return "redirect:/saleItems";
    }
}

