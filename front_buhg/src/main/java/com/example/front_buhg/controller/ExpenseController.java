package com.example.front_buhg.controller;

import com.example.front_buhg.model.Expense;
import com.example.front_buhg.service.CoffeeShopApi;
import com.example.front_buhg.service.ExpenseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseApi expenseApi;

    @Autowired
    private CoffeeShopApi shopApi;

    @GetMapping
    public String getAllExpenses(Model model) {
        Expense[] expenses = expenseApi.getAll();
        model.addAttribute("expenses", expenses);

        return "expenses/expenses";
    }


    @GetMapping("/{id}")
    public String getExpenseById(@PathVariable Long id, Model model) {
        Expense expense = expenseApi.getById(id);
        model.addAttribute("expense", expense);

        return "expenses/expense";
    }


    @GetMapping("/create")
    public String createExpense(Model model) {
        model.addAttribute("expense", new Expense());

        return "expenses/createExpense";
    }


    @PostMapping("/create")
    public String saveExpense(@RequestParam Long shopId, Expense expense) {
        expense.setCoffeeShop(shopApi.getById(shopId));
        expenseApi.save(expense);

        return "redirect:/expenses";
    }


    @GetMapping("/update/{id}")
    public String updateExpense(@PathVariable Long id, Model model) {
        Expense expense = expenseApi.getById(id);
        model.addAttribute("expense", expense);

        return "expenses/updateExpense";
    }


    @PostMapping("/update/{id}")
    public String updateExpense(@PathVariable Long id, @RequestParam Long shopId, Expense expense) {
        expense.setCoffeeShop(shopApi.getById(shopId));
        expenseApi.update(expense, id);

        return "redirect:/expenses";
    }


    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseApi.delete(id);

        return "redirect:/expenses";
    }

}
