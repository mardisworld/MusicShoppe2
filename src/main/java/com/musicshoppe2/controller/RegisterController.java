package com.musicshoppe2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musicshoppe2.model.BillingAddress;
import com.musicshoppe2.model.Customer;
import com.musicshoppe2.model.ShippingAddress;
import com.musicshoppe2.services.CustomerService;

/** Created by Marissa on 7/10/17. */

@Controller
public class RegisterController {

  @Autowired
  private CustomerService customerService;

  @RequestMapping("/register")
  public String registerCustomer(Model model) {

    Customer customer = new Customer();
    BillingAddress billingAddress = new BillingAddress();
    ShippingAddress shippingAddress = new ShippingAddress();
    customer.setBillingAddress(billingAddress);
    customer.setShippingAddress(shippingAddress);

    model.addAttribute("customer", customer);

    return "registerCustomer";

  }

  @RequestMapping("/register")
  public String registerCustomerPost(@ModelAttribute("customer") Customer customer, Model model) {

    customer.setEnabled(true);
    customerService.addCustomer(customer);

    return "registerCustomerSucess";

  }
}
