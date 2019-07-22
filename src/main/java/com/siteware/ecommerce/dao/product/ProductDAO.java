package com.siteware.ecommerce.dao.product;

import com.siteware.ecommerce.pojo.product.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Class responsible for communicating the system
 * with the persistance context of the application.
 *
 * @author Antunes Dantas
 */
@Transactional(Transactional.TxType.MANDATORY)
@Component
public class ProductDAO {

    private static final String GET_PRODUCT_BY_ID = new StringBuilder()
            .append("FROM Product prod WHERE prod.id = :id").toString();

    private static final String DELETE_PRODUCT_BY_ID = new StringBuilder()
            .append("DELETE FROM Product prod WHERE prod.id = :id").toString();

    private static final String GET_ALL_PRODUCTS = new StringBuilder()
            .append("FROM Product").toString();

    private static final String GET_PRODUCTS_WITH_IDS = new StringBuilder()
            .append("FROM Product prod WHERE prod.id in :ids").toString();

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a single Product with the provided Id.
     *
     * @param id Id of the requested Product.
     *
     * @return The requested Product.
     */
    public Product findProductById(Long id) {
        TypedQuery<Product> query = getEntityManager()
                .createQuery(GET_PRODUCT_BY_ID, Product.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    /**
     * Retrieves all the Products persisted.
     *
     * @return A List with all the Products saved on the system.
     */
    public List<Product> findAllProducts() {
        TypedQuery<Product> query = getEntityManager()
                .createQuery(GET_ALL_PRODUCTS, Product.class);

        return query.getResultList();
    }

    /**
     * Retrieves all the Products which it's Id is on the list
     * passed as paremeter.
     *
     * @param ids List of Ids of the products to be retrieved.
     *
     * @return A List with the Products.
     */
    public List<Product> findProductsByListOfId(List<Long> ids) {
        TypedQuery<Product> query = getEntityManager()
                .createQuery(GET_PRODUCTS_WITH_IDS, Product.class);
        query.setParameter("ids", ids);

        return query.getResultList();
    }

    /**
     * Persist a sigle Product on the database.
     *
     * @param product The Product to be persisted.
     */
    public void persistProduct(Product product) {
        getEntityManager().persist(product);
    }

    /**
     * Updates an existing Product on the database.
     *
     * @param product The Product with the new values.
     *
     * @return The updated Product.
     */
    public Product updateProduct(Product product) {
        return getEntityManager().merge(product);
    }

    /**
     * Deletes a Product from the database.
     *
     * @param id The id of the Product which will be removed.
     */
    public void deleteProduct(Long id) {
        Query query = getEntityManager()
                .createQuery(DELETE_PRODUCT_BY_ID);
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
