package com.siteware.ecommerce.service.cart;

import com.siteware.ecommerce.pojo.checkout.Cart;

public interface CartService {

    /**
     * Retrieves a persisted Cart with the given Id.
     *
     * @param id Id of the wished Cart.
     *
     * @return The Cart with the given Id.
     */
    public Cart getCart(Long id);

    /**
     * Persists a new Cart in the database.
     *
     * @param cart the Cart which will be saved.
     *
     * @return The created Cart.
     */
    public Cart createCart(Cart cart);

    /**
     * Deletes a Cart from the database.
     *
     * @param id The id of the Cart to be deleted.
     */
    public void deleteCart(Long id) ;

    /**
     * Updates an existing Cart on the system.
     *
     * @param cart The Cart with the updated fields.
     *
     * @return The updated Cart.
     */
    public Cart updateCart(Cart cart);

}
