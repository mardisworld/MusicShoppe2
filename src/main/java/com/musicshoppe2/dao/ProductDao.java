package com.musicshoppe2.dao;

import com.musicshoppe2.model.Product;
import java.util.List;

/**
 * Created by Marissa on 6/16/17.
 */
public interface ProductDao {

    void addProduct(Product product);

    Product getProductById(String id);

    List<Product> getAllProducts();

    void deleteProduct(String id);


}
