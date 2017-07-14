package com.musicshoppe2.controller.Admin;

import com.musicshoppe2.model.Product;
import com.musicshoppe2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Marissa on 7/9/17.
 */

@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("productInventory")
    public String productInventory(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products)

        return "productInventory";
    }

    @RequestMapping
    public String customerManagement(Model model) {
        //to add some customer service later
        return "customerManagement";

    }
}
