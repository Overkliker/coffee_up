package com.example.front_buhg.controller;

import com.example.front_buhg.model.CoffeeShop;
import com.example.front_buhg.service.CoffeeShopApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/coffeeShops")
public class CoffeeShopController {
    @Autowired
    private CoffeeShopApi coffeeShopApi;

    @GetMapping

    public String getAllShops(Model model) {

        CoffeeShop[] shops = coffeeShopApi.getCoffeeShops();

        model.addAttribute("shops", shops);

        return "shops/coffeeShops";

    }


    @GetMapping("/{id}")

    public String getShopById(@PathVariable Long id, Model model) {

        CoffeeShop shop = coffeeShopApi.getById(id);

        model.addAttribute("shop", shop);

        return "shops/coffeeShop";

    }


    @GetMapping("/create")

    public String createShop(Model model) {

        model.addAttribute("shop", new CoffeeShop());

        return "shops/createCoffeeShop";

    }


    @PostMapping("/create")

    public String saveShop(CoffeeShop shop) {

        coffeeShopApi.save(shop);

        return "redirect:/coffeeShops";

    }


    @GetMapping("/update/{id}")

    public String updateShop(@PathVariable Long id, Model model) {

        CoffeeShop shop = coffeeShopApi.getById(id);

        model.addAttribute("shop", shop);

        return "shops/updateCoffeeShop";

    }


    @PostMapping("/update/{id}")
    public String updateShop(@PathVariable Long id, CoffeeShop shop) {

        coffeeShopApi.update(shop, id);

        return "redirect:/coffeeShops";

    }


    @GetMapping("/delete/{id}")

    public String deleteShop(@PathVariable Long id) {

        coffeeShopApi.delete(id);

        return "redirect:/coffeeShops";

    }

}