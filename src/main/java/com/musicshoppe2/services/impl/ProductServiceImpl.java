package com.musicshoppe2.services.impl;

import com.musicshoppe2.dao.ProductDao;
import com.musicshoppe2.model.Product;
import com.musicshoppe2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by Marissa on 7/9/17. */

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductDao productDao;

  public List<Product> getProductList() {
    return productDao.getProductList();
  }

  public void addProduct(Product product) {
    productDao.addProduct(product);
  }

  public void editProduct(Product product) {
    productDao.editProduct(product);
  }

  public void deleteProduct(Product product) {
    productDao.deleteProduct(product);
  }

  @Override
  public Product getProductById(int id) {
    return productDao.getProductById(id);
  }

}
