package com.musicshoppe2.dao.impl;

import com.musicshoppe2.dao.ProductDao;
import com.musicshoppe2.model.Product;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Marissa on 6/16/17.
 *
 */

//standard practice to define ProductDao and ProductDao implementation
//First you have an interface, then an implementation.
//In data (later), you can autowire by interface and Spring will find those beans and automatically wire them - inject them into the Spring
//(con't) container as beans.
//3 types of annotations - controller, repository, and service - whenever Spring sees that annotation, will scan that class.


@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;   //defined in applicationContext.xml

    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();

        return product;
    }

    public List<Product> getProductList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> productList= query.list();
        session.flush();

        return productList;
    }

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void deleteProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

}
