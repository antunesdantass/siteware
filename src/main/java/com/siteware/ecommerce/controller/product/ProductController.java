package com.siteware.ecommerce.controller.product;

import com.siteware.ecommerce.pojo.product.Product;
import com.siteware.ecommerce.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller responsible for providing the services for the
 * Product entity.
 *
 * @author Antunes Dantas
 */
@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * Lists all the Products persisted.
     *
     * @return a List with all the Products.
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Save a new Product.
     *
     * @param product The Product which will be saved.
     *
     * @return The saved Product.
     */
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    /**
     * Request a specific Product.
     *
     * @param id the Id of the requested Product.
     *
     * @return The requested Product.
     */
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    /**
     * Updates a Product.
     *
     * @param id The Id of the Product to be updated.
     *
     * @param product the Product with the new data.
     *
     * @return the updated Product.
     */
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(product);
    }

    /**
     * Deletes a Product.
     *
     * @param id the Id of the Product to be deleted.
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

}
