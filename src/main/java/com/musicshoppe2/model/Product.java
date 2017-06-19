package com.musicshoppe2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Marissa on 6/4/17.
 */

@Entity
public class Product { //@Entity tells Spring that Java class is an entity that we want to be stored in the database - persist this table into the database

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String productId;   //need this in order to bind productList page with productDetail page
    private String productName;  //will be "persisted" to a database - each instance of the class corresponds to one row of the table
    private String productCategory;   //Id defines primary key in the table
    private String productDescription;   // @GeneratedValue(strategy = GenerationType.AUTO) - tells the system that
    private double productPrice;        //when we create a new instance and it persists to a data base the productId
    private String productCondition;  //will be generated automatically
    private String productStatus;
    private int unitInStock;
    private String productManufacturer;

    public String getProductId() { return productId; }

    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

}
