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
    Product getProduct(Long id);

    /**
     * Persists a new Product in the database.
     *
     * @param product the Product which will be saved.
     *
     * @return The created Product.
     */
    Product createProduct(Product product);

    /**
     * Retrieves all the persisted Products on the system.
     *
     * @return A List with all the Products.
     */
    List<Product> getAllProducts();

    /**
     * Deletes a Product from the database.
     *
     * @param id The id of the Product to be deleted.
     */
    void deleteProduct(Long id) ;

    /**
     * Updates an existing Product on the system.
     *
     * @param product The Product with the updated fields.
     *
     * @return The updated Product.
     */
    Product updateProduct(Product product);

    /**
     * Retrieves all the Products which it's Id is on the list
     * passed as paremeter.
     *
     * @param ids List of Ids of the products to be retrieved.
     *
     * @return List of Products.
     */
    List<Product> getProductsById(List<Long> ids);

}
