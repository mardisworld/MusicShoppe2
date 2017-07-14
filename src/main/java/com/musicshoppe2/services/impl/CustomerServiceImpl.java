package com.musicshoppe2.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicshoppe2.dao.CustomerDao;
import com.musicshoppe2.model.Customer;
import com.musicshoppe2.services.CustomerService;

/** Created by Marissa on 7/14/17. */

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerDao customerDao;

  public void addCustomer(Customer customer) {
    customerDao.addCustomer(customer);
  }

  public Customer getCustomerById(int customerId) {
    return customerDao.getCustomerById(customerId);
  }

  public List<Customer> getAllCustomers() {
    return customerDao.getAllCustomers();

  }

}
