package com.musicshoppe2.services;

import java.util.List;

import com.musicshoppe2.model.Customer;

/** Created by Marissa on 7/14/17. */
public interface CustomerService {

  void addCustomer(Customer customer);

  Customer getCustomerById(int customerId);

  List<Customer> getAllCustomers();

}
