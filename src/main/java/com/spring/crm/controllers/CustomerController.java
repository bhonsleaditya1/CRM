package com.spring.crm.controllers;

import com.spring.crm.entity.Customer;
import com.spring.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    //inject customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        //get customers from dao
        List<Customer> customers = customerService.getCustomers();

        // add customers from dao
        theModel.addAttribute("customers",customers);

        return "list-customers";
    }
    @GetMapping("/show-form-add")
    public String showFormAdd(Model model){

        // create model attribute to bind data
        Customer customer = new Customer();
        model.addAttribute("customer",customer);

        return "customer-form";
    }
    @PostMapping("/save-customer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        //save customer
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }
    @GetMapping("/show-form-update")
    public String showFormUpdate(@RequestParam("customerId") int id,Model model){
        // get customer form database
        Customer customer = customerService.getCustomer(id);
        // set customer model attribute to pre-populate form
        model.addAttribute("customer",customer);
        //send over to form
        return "customer-form";
    }
}

