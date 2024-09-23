package com.example.front_buhg.controller;

import com.example.front_buhg.model.Employee;
import com.example.front_buhg.service.CoffeeShopApi;
import com.example.front_buhg.service.EmployeeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
@PreAuthorize("hasAuthority('MANAGER')")
public class EmployeeController {
    @Autowired
    private EmployeeApi employeeApi;

    @Autowired
    private CoffeeShopApi shopApi;

    @GetMapping
    public String getAll(Model model) {

        Employee[] employee = employeeApi.getAll();

        model.addAttribute("employees", employee);

        return "employees/employees";

    }


    @GetMapping("/{id}")

    public String getById(@PathVariable Long id, Model model) {

        Employee employee = employeeApi.getById(id);

        model.addAttribute("employee", employee);

        return "employees/employee";

    }


    @GetMapping("/create")

    public String create(Model model) {

        model.addAttribute("employee", new Employee());

        return "employees/createEmployee";

    }


    @PostMapping("/create")

    public String save(@RequestParam Long shopId, Employee employee) {
        employee.setCoffeeShop(shopApi.getById(shopId));
        employeeApi.save(employee);

        return "redirect:/employees";

    }


    @GetMapping("/update/{id}")

    public String update(@PathVariable Long id, Model model) {

        Employee employee = employeeApi.getById(id);

        model.addAttribute("employee", employee);

        return "employees/updateEmployee";

    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestParam Long shopId, Employee employee) {

        employee.setCoffeeShop(shopApi.getById(shopId));
        employeeApi.update(employee, id);

        return "redirect:/employees";

    }


    @GetMapping("/delete/{id}")

    public String delete(@PathVariable Long id) {

        employeeApi.delete(id);

        return "redirect:/employees";

    }
}
