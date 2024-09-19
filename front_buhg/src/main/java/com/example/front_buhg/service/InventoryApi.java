package com.example.front_buhg.service;

import com.example.front_buhg.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InventoryApi {

    private final RestTemplate restTemplate;


    @Autowired
    public InventoryApi(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;

    }


    public Inventory[] getAll() {

        String url = "http://localhost:8000/api/v1/inventory";

        return restTemplate.getForObject(url, Inventory[].class);
    }

    public void save(Inventory shop) {

        String url = "http://localhost:8000/api/v1/inventory";

        restTemplate.postForObject(url, shop, Inventory.class);
    }

    public void update(Inventory inventory, Long id) {

        String url = "http://localhost:8000/api/v1/inventory/" + id;

        restTemplate.postForObject(url, inventory, Inventory.class);
    }


    public Inventory getById(Long id) {

        String url = "http://localhost:8000/api/v1/inventory/" + id;

        return restTemplate.getForObject(url, Inventory.class);
    }

    public void delete(Long id) {

        String url = "http://localhost:8000/api/v1/inventory/" + id;

        restTemplate.delete(url);
    }
}
