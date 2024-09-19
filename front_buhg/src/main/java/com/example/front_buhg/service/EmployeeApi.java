package com.example.front_buhg.service;

import com.example.front_buhg.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeApi {

    private final RestTemplate restTemplate;


    @Autowired
    public EmployeeApi(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;

    }


    public Employee[] getAll() {

        String url = "http://localhost:8000/api/v1/employee";

        return restTemplate.getForObject(url, Employee[].class);
    }

    public void save(Employee shop) {

        String url = "http://localhost:8000/api/v1/employee";

        restTemplate.postForObject(url, shop, Employee.class);
    }

    public void update(Employee shop, Long id) {

        String url = "http://localhost:8000/api/v1/employee/" + id;

        restTemplate.postForObject(url, shop, Employee.class);
    }


    public Employee getById(Long id) {

        String url = "http://localhost:8000/api/v1/employee/" + id;

        return restTemplate.getForObject(url, Employee.class);
    }

    public void delete(Long id) {

        String url = "http://localhost:8000/api/v1/employee/" + id;

        restTemplate.delete(url);
    }
}
