package com.example.front_buhg.service;

import com.example.front_buhg.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductApi {

    private final RestTemplate restTemplate;


    @Autowired
    public ProductApi(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;

    }


    public Product[] getAll() {

        String url = "http://localhost:8000/api/v1/products";

        return restTemplate.getForObject(url, Product[].class);
    }

    public void save(Product shop) {

        String url = "http://localhost:8000/api/v1/products";

        restTemplate.postForObject(url, shop, Product.class);
    }

    public void update(Product shop, Long id) {

        String url = "http://localhost:8000/api/v1/products/" + id;

        restTemplate.postForObject(url, shop, Product.class);
    }


    public Product getById(Long id) {

        String url = "http://localhost:8000/api/v1/products/" + id;

        return restTemplate.getForObject(url, Product.class);
    }

    public void delete(Long id) {

        String url = "http://localhost:8000/api/v1/products/" + id;

        restTemplate.delete(url);
    }
}
