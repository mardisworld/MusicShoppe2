package com.musicshoppe2.dao;

import com.musicshoppe2.model.Product;

import java.io.IOException;
import java.util.List;

/**
 * Created by Marissa on 6/16/17.
 */
public interface ProductDao {

    void addProduct(Product product);

    Product getProductById(int id);

    List<Product> getAllProducts();

    void deleteProduct(int id);

    void editProduct(Product product);


}
