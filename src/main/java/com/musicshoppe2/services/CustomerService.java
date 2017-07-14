package com.musicshoppe2.services;

import com.musicshoppe2.model.Customer;

/**
 * Created by Marissa on 7/14/17.
 */
public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCutomerById(int customerId);

    List<Customer> getAllCustomers();




}
