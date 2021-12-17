package com.spring.crm.controllers;

import com.spring.crm.dao.CustomerDAO;
import com.spring.crm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    // inject customer dao
    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        //get customers from dao
        List<Customer> customers = customerDAO.getCustomers();

        // add customers from dao
        theModel.addAttribute("customers",customers);

        return "list-customers";
    }
}

