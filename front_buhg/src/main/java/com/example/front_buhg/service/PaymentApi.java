package com.example.front_buhg.service;

import com.example.front_buhg.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentApi {

    private final RestTemplate restTemplate;


    @Autowired
    public PaymentApi(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;

    }


    public Payment[] getAll() {

        String url = "http://localhost:8000/api/v1/payments";

        return restTemplate.getForObject(url, Payment[].class);
    }

    public void save(Payment shop) {

        String url = "http://localhost:8000/api/v1/payments";

        restTemplate.postForObject(url, shop, Payment.class);
    }

    public void update(Payment shop, Long id) {

        String url = "http://localhost:8000/api/v1/payments/" + id;

        restTemplate.postForObject(url, shop, Payment.class);
    }


    public Payment getById(Long id) {

        String url = "http://localhost:8000/api/v1/payments/" + id;

        return restTemplate.getForObject(url, Payment.class);
    }

    public void delete(Long id) {

        String url = "http://localhost:8000/api/v1/payments/" + id;

        restTemplate.delete(url);
    }
}
