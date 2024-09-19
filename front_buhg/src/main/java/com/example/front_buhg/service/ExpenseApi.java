package com.example.front_buhg.service;

import com.example.front_buhg.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExpenseApi {

    private final RestTemplate restTemplate;


    @Autowired
    public ExpenseApi(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;

    }


    public Expense[] getAll() {

        String url = "http://localhost:8000/api/v1/expense";

        return restTemplate.getForObject(url, Expense[].class);
    }

    public void save(Expense shop) {

        String url = "http://localhost:8000/api/v1/expense";

        restTemplate.postForObject(url, shop, Expense.class);
    }

    public void update(Expense shop, Long id) {

        String url = "http://localhost:8000/api/v1/expense/" + id;

        restTemplate.postForObject(url, shop, Expense.class);
    }


    public Expense getById(Long id) {

        String url = "http://localhost:8000/api/v1/expense/" + id;

        return restTemplate.getForObject(url, Expense.class);
    }

    public void delete(Long id) {

        String url = "http://localhost:8000/api/v1/expense/" + id;

        restTemplate.delete(url);
    }
}
