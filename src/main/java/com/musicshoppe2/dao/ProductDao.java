package com.musicshoppe2.dao;

import com.musicshoppe2.model.Product;

import java.util.List;

/**
 * Created by Marissa on 6/16/17.
 */
public interface ProductDao {


    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

}
