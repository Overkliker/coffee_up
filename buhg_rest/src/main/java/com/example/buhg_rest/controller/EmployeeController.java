package com.example.buhg_rest.controller;

import com.example.buhg_rest.model.Employee;
import com.example.buhg_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PostMapping
    public Employee create(@RequestBody Employee shop) {
        return employeeService.save(shop);
    }

    @PostMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee details) {
        Employee employee = employeeService.getById(id);
        employee.setName(details.getName());
        employee.setCoffeeShop(details.getCoffeeShop());
        employee.setHireDate(details.getHireDate());
        employee.setPosition(details.getPosition());
        employee.setSalary(details.getSalary());
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
