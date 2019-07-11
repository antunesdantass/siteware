package com.siteware.ecommerce.service.product;

import com.siteware.ecommerce.pojo.product.Product;

import java.util.List;

/**
 * This interface discribes what services will be provided
 * for the Product entity.
 *
 * @author Antunes Dantas
 */
public interface ProductService {

    /**
     * Retrieves a persisted Product with the given Id.
     *
     * @param id Id of the wished Product.
     *
     * @return The Product with the given Id.
     */
    public Product getProduct(Long id);

    /**
     * Persists a new Product in the database.
     *
     * @param product the Product which will be saved.
     *
     * @return The created Product.
     */
    public Product createProduct(Product product);

    /**
     * Retrieves all the persisted Products on the system.
     *
     * @return A List with all the Products.
     */
    public List<Product> getAllProducts();

    /**
     * Deletes a Product from the database.
     *
     * @param id The id of the Product to be deleted.
     */
    public void deleteProduct(Long id) ;

    /**
     * Updates an existing Product on the system.
     *
     * @param product The Product with the updated fields.
     *
     * @return The updated Product.
     */
    public Product updateProduct(Product product);

}
