package com.spring.crm.dao;

import com.spring.crm.entity.Customer;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

        // save/update customer
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        // get current hibernate session
        Session session = sessionFactory.getCurrentSession();
        // retrive/read from database using primary key
        return session.get(Customer.class,id);
    }

    @Override
    public void deleteCustomer(int id) {
        // get current hibernate session
        Session session = sessionFactory.getCurrentSession();
        // delete object with primary key
        Query query = session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId",id);
        query.executeUpdate();
    }
}
