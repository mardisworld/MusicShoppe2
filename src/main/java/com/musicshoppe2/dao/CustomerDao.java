package com.musicshoppe2.dao;

import com.musicshoppe2.model.Customer;

import java.util.List;

/**
 * Created by Marissa on 7/14/17.
 */
public interface CustomerDao {


    void addCustomer(Customer customer);

    Customer getCutomerById(int customerId);

    List<Customer> getAllCustomers();




}
