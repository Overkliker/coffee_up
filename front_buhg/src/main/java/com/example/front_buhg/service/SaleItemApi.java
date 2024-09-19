package com.example.front_buhg.service;

import com.example.front_buhg.model.SaleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SaleItemApi {
    private final RestTemplate restTemplate;


    @Autowired
    public SaleItemApi(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;

    }


    public SaleItem[] getAll() {

        String url = "http://localhost:8000/api/v1/saleItem";

        return restTemplate.getForObject(url, SaleItem[].class);
    }

    public void save(SaleItem shop) {

        String url = "http://localhost:8000/api/v1/saleItem";

        restTemplate.postForObject(url, shop, SaleItem.class);
    }

    public void update(SaleItem shop, Long id) {

        String url = "http://localhost:8000/api/v1/saleItem/" + id;

        restTemplate.postForObject(url, shop, SaleItem.class);
    }


    public SaleItem getById(Long id) {

        String url = "http://localhost:8000/api/v1/sales/" + id;

        return restTemplate.getForObject(url, SaleItem.class);
    }

    public void delete(Long id) {

        String url = "http://localhost:8000/api/v1/sales/" + id;

        restTemplate.delete(url);
    }
}
