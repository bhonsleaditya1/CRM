package com.spring.crm.dao;

import com.spring.crm.entity.Customer;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class CustomerDAOImpl implements CustomerDAO{

    // need to inject session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        // get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // create query
        Query<Customer> query = session.createQuery("from Customer order by lastName",
                Customer.class);

        // execute query and get result list
        List<Customer> customers = query.getResultList();

        // return results
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        // get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // save customer
        session.save(customer);
    }
}
