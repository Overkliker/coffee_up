package com.example.front_buhg.service;

import com.example.front_buhg.model.CoffeeShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoffeeShopApi {

    private final RestTemplate restTemplate;


    @Autowired
    public CoffeeShopApi(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;

    }


    public CoffeeShop[] getCoffeeShops() {

        String url = "http://localhost:8000/api/v1/coffeeShops";

        return restTemplate.getForObject(url, CoffeeShop[].class);
    }

    public void save(CoffeeShop shop) {

        String url = "http://localhost:8000/api/v1/coffeeShops";

        restTemplate.postForObject(url, shop, CoffeeShop.class);
    }

    public void update(CoffeeShop shop, Long id) {

        String url = "http://localhost:8000/api/v1/coffeeShops/update/" + id;

        restTemplate.postForObject(url, shop, CoffeeShop.class);
    }


    public CoffeeShop getById(Long id) {

        String url = "http://localhost:8000/api/v1/coffeeShops/" + id;

        return restTemplate.getForObject(url, CoffeeShop.class);
    }

    public void delete(Long id) {

        String url = "http://localhost:8000/api/v1/coffeeShops/delete/" + id;

        restTemplate.delete(url);
    }
}
