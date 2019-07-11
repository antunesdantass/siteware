package com.siteware.ecommerce.dao.cart;

import com.siteware.ecommerce.pojo.checkout.Cart;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 * Class responsible for communicating the system
 * with the persistance context of the application.
 *
 * @author Antunes Dantas
 */
@Transactional(Transactional.TxType.MANDATORY)
public class CartDAO {

    private static final String GET_CART_BY_ID = new StringBuilder()
            .append("FROM Cart cart WHERE cart.id = :id").toString();

    private static final String DELETE_CART_BY_ID = new StringBuilder()
            .append("DELETE FROM Cart cart WHERE cart.id = :id").toString();

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a single Cart with the provided Id.
     *
     * @param id Id of the requested Product.
     *
     * @return The requested Cart.
     */
    public Cart findCartById(Long id) {
        TypedQuery<Cart> query = getEntityManager()
                .createQuery(GET_CART_BY_ID, Cart.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    /**
     * Persist a sigle Cart on the database.
     *
     * @param cart The Cart to be persisted.
     */
    public void persistCart(Cart cart) {
        getEntityManager().persist(cart);
    }

    /**
     * Updates an existing Cart on the database.
     *
     * @param cart The Cart with the new values.
     *
     * @return The updated Cart.
     */
    public Cart updateCart(Cart cart) {
        return getEntityManager().merge(cart);
    }

    /**
     * Deletes a Cart from the database.
     *
     * @param id The id of the Cart which will be removed.
     */
    public void deleteCart(Long id) {
        Query query = getEntityManager()
                .createQuery(DELETE_CART_BY_ID);
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
