package com.siteware.ecommerce.business.cart;

import com.siteware.ecommerce.dto.checkout.CartDTO;
import org.springframework.stereotype.Service;


/**
 * Provides business logic for the Cart
 *
 * @author Antunes Dantas
 */
@Service
public class CartBusinessDelegate {

    /**
     * Just returns the Cart because Jackson (the parser for JSON)
     * will automatically calculate the total amount.
     * @param cart
     * @return
     */
    public CartDTO calculateCart(CartDTO cart) {
        return cart;
    }
}
