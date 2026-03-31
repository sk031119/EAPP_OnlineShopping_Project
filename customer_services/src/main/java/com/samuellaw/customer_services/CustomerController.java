/*
 * Requirements:
 * - Thymeleaf controller for customer CRUD UI
 * - GET  /customers         -> list all customers
 * - GET  /customer/new      -> show blank form
 * - GET  /customer/edit/{id}-> show pre-filled form
 * - POST /customer/save     -> insert/update customer record
 * - GET  /customer/delete/{id} -> delete customer
 */
package com.samuellaw.customer_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers";
    }

    @GetMapping("/customer/new")
    public String showForm(Model model) {
        model.addAttribute("customer", new CustomerEntity());
        return "customer-form";
    }

    @GetMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer-form";
    }

    @PostMapping("/customer/save")
    public String saveCustomer(@ModelAttribute CustomerEntity customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return "redirect:/customers";
    }
}
