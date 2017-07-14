package com.musicshoppe2.dao.impl;

import com.musicshoppe2.model.Authorities;
import com.musicshoppe2.model.Cart;
import com.musicshoppe2.model.Customer;
import com.musicshoppe2.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.List;

/** Created by Marissa on 7/14/17. */

@Repository
@Transactional
public class CustomerDaoImpl {

  @Autowired
  private SessionFactory sessionFactory;

  public void addCustomer(Customer customer) {

    Session session = sessionFactory.getCurrentSession();

    customer.getBillingAddress().setCustomer(customer);
    customer.getShippingAddress().setCustomer(customer);

    session.saveOrUpdate(customer);
    session.saveOrUpdate(customer.getBillingAddress());
    session.saveOrUpdate(customer.getShippingAddress());

    Users newUser = new Users();
    newUser.setUsername(customer.getUsername());
    newUser.setPassword(customer.getPassword());
    newUser.setEnabled(true);
    newUser.setCustomerId(customer.getCustomerId());

    Authorities newAuthority = new Authorities();
    newAuthority.setUsername(customer.getUsername());
    newAuthority.setAuthority("ROLE_USER");

    session.saveOrUpdate(newUser);
    session.saveOrUpdate(newAuthority);

    Cart newCart = new Cart();
    newCart.setCustomer(customer);
    customer.setCart(newCart);
    session.saveOrUpdate(customer);
    session.saveOrUpdate(newCart);

    session.flush();

  }

  public Customer getCustomerById(int customerId) {
    Session session = sessionFactory.getCurrentSession();
    return (Customer)session.get(Customer.class, customerId);
  }

//  public List<Customer> gtAllCustomers() {
//            Session session = sessionFactory.getCurrentSession();
//            Query query = session.createQuery("frp,")
//
//
//    }

}
