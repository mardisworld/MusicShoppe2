package com.musicshoppe2.controller;

import com.musicshoppe2.dao.ProductDao;
import com.musicshoppe2.model.Product;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Marissa on 6/3/17.
 */

@Controller
public class HomeController {

    private Path path;


    @Autowired
    private ProductDao productDao;


    @RequestMapping("/")
    public String home() {
        return "home";
    }


    @RequestMapping("/productList")
    public String getProducts(Model model) {  //function imports model parameter, which will be attached to view of
        List<Product> products = productDao.getAllProducts();

        model.addAttribute("products", products);  //In model, we attached products to model, gave it a name of products

        //List<Product> productList=productDao.getProductList();

        //Product product = productList.get(0);  //refer product to productList
        // model.addAttribute(product);  //bind product to model object
        return "productList"; //when we return productList, model will be attached to the view automatically

    }

    @RequestMapping("/productList/viewProduct/{productId}")  //productId is path variable
    public String viewProduct(@PathVariable int productId, Model model) throws IOException {  //takes in path variable as param,
        //passes it on to model so string will have context of productId

        Product product = productDao.getProductById(productId);  //will return a product given its id

        model.addAttribute(product);
        return "viewProduct";

    }


    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        return "productInventory";

    }


    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProductCategory("instrument"); //default category
        product.setProductCondition("New");
        product.setProductStatus("Active");
        model.addAttribute("product", product);
        return "addProduct";

    }


    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "addProduct";
        }
        productDao.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.", e);

            }
        }

        return "redirect:/admin/productInventory";

    }


    @RequestMapping("/admin/productInventory/deleteProduct/{id}")  //productId is path variable
    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {  //takes in path variable as param,
        //passes it on to model so string will have context of productId
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id+".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        productDao.deleteProduct(id);
        return "redirect:/admin/productInventory";

    }


    @RequestMapping("/admin/productInventory/editProduct/{id}")  //productId is path variable
    public String editProduct(@PathVariable("id") int id, Model model, HttpServletRequest request) {  //takes in path variable as param,
        //passes it on to model so string will have context of productId

        Product product = productDao.getProductById(id);
        model.addAttribute(product);
        return "editProduct";

    }


    @RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
    public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "editProduct";
        }

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                throw new RuntimeException("Product image saving failed.", e);
            }
        }

        productDao.editProduct(product);
        return "redirect:/admin/productInventory";

    }
}
