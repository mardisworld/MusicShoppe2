package com.musicshoppe2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.musicshoppe2.model.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;


import com.musicshoppe2.model.CartItem;


/**
 * Created by Marissa on 7/9/17.
 */


@Entity
public class Product implements Serializable {

    //need to generate serialversionUID but can't figure out how
    //https://stackoverflow.com/questions/24573643/how-to-generate-serial-version-uid-in-intellij




    @Id
    @GeneratedValue
    private String productId;


    @NotEmpty (message = "The product name must not be null.")

    private String productName;
    private String productCategory;
    private String productDescription;

    @Min(value=0, message="THe product price cannot be less than $0")
    private double producPrice;
    private String productCondition;
    private String productStatus;

    @Min(value=0, message="THe product unit cannot be less than $0")
    private int unitInStock;
    private String productManufacturer;

    @Transient
    private MultipartFile productImage;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

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

    public double getProducPrice() {
        return producPrice;
    }

    public void setProducPrice(double producPrice) {
        this.producPrice = producPrice;
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

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}
