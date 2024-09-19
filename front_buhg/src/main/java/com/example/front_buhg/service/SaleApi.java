package com.example.front_buhg.service;

import com.example.front_buhg.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SaleApi {

    private final RestTemplate restTemplate;


    @Autowired
    public SaleApi(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;

    }


    public Sale[] getAll() {

        String url = "http://localhost:8000/api/v1/sales";

        return restTemplate.getForObject(url, Sale[].class);
    }

    public void save(Sale shop) {

        String url = "http://localhost:8000/api/v1/sales";

        restTemplate.postForObject(url, shop, Sale.class);
    }

    public void update(Sale shop, Long id) {

        String url = "http://localhost:8000/api/v1/sales/" + id;

        restTemplate.postForObject(url, shop, Sale.class);
    }


    public Sale getById(Long id) {

        String url = "http://localhost:8000/api/v1/sales/" + id;

        return restTemplate.getForObject(url, Sale.class);
    }

    public void delete(Long id) {

        String url = "http://localhost:8000/api/v1/sales/" + id;

        restTemplate.delete(url);
    }
}
