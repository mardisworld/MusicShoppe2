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

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();  //Only when you flush it will session operations be executed

    }

    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);  //casting Product into object type
        session.flush();

        return product;

    }

    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Product");
        List<Product> products=query.list();
        session.flush();
        return products;

        //@SuppressWarnings("unchecked")
       // query = session.createFilter(List, "from Product").Q createQuery("from Product"). .createQuery("from Product");
        //org.hibernate.query.Query = session .createQuery("from Product");   //???
       // List<Product> products = query.getResultList();  //cannot resolve symbol 'query'


    }

    public void deleteProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProductById(id));
        session.flush();

    }

    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

}
