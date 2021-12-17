package com.spring.crm.service;

import com.spring.crm.dao.CustomerDAO;
import com.spring.crm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerSerivceImpl implements CustomerService{
    // inject customer dao
    @Autowired
    CustomerDAO customerDAO;

    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }
}
