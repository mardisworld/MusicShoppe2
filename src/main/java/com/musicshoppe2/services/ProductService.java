package com.musicshoppe2.services;

import com.musicshoppe2.model.Product;

import java.util.List;

/**
 * Created by Marissa on 7/9/17.
 */
public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

}
