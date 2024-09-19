package com.example.buhg_rest.service;

import com.example.buhg_rest.model.Employee;
import com.example.buhg_rest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeService;

    @Autowired
    public EmployeeService(EmployeeRepository employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    public Employee getById(Long id) {
        return employeeService.findById(id).orElseThrow(() -> new RuntimeException("Shop not found"));
    }

    public Employee save(Employee shop) {
        return employeeService.save(shop);
    }

    public void delete(Long id) {
        employeeService.deleteById(id);
    }
}