package com.example.front_buhg.controller;

import com.example.front_buhg.model.Sale;
import com.example.front_buhg.service.CoffeeShopApi;
import com.example.front_buhg.service.EmployeeApi;
import com.example.front_buhg.service.SaleApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleApi saleApi;

    @Autowired
    private CoffeeShopApi coffeeShopApi;

    @Autowired
    private EmployeeApi employeeApi;

    @GetMapping
    public String getAllProducts(Model model) {
        Sale[] products = saleApi.getAll();
        model.addAttribute("sales", products);
        return "sales/sales";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        Sale sale = saleApi.getById(id);
        model.addAttribute("sale", sale);

        model.addAttribute("shops", coffeeShopApi.getCoffeeShops());
        model.addAttribute("employees", employeeApi.getAll());
        return "sales/sale";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("sale", new Sale());
        model.addAttribute("shops", coffeeShopApi.getCoffeeShops());
        model.addAttribute("employees", employeeApi.getAll());
        return "sales/createSale";
    }

    @PostMapping("/create")
    public String saveProduct(@RequestParam Long shopId, @RequestParam Long employeeId, Sale sale) {
        sale.setCoffeeShop(coffeeShopApi.getById(shopId));
        sale.setEmployee(employeeApi.getById(employeeId));
        saleApi.save(sale);
        return "redirect:/sales";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @RequestParam Long shopId, @RequestParam Long employeeId, Sale sale) {
        sale.setCoffeeShop(coffeeShopApi.getById(shopId));
        sale.setEmployee(employeeApi.getById(employeeId));
        saleApi.update(sale, id);
        return "redirect:/sales";

    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        saleApi.delete(id);
        return "redirect:/sales";
    }
}
