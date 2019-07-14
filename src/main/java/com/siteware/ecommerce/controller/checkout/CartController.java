package com.siteware.ecommerce.controller.checkout;

import com.siteware.ecommerce.business.cart.CartBusinessDelegate;
import com.siteware.ecommerce.dto.checkout.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller responsible for providing the services for the
 * Cart entity.
 *
 * @author Antunes Dantas
 */
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartBusinessDelegate cartBusinessDelegate;

    /**
     * Calculates the price for the item's on the Cart.
     *
     * @param cartDTO a Cart's DTO with the item's on it.
     *
     * @return an updated Cart with it's price calculated.
     */
    @PostMapping
    public CartDTO calculateCart(@RequestBody CartDTO cartDTO) {
        return cartBusinessDelegate.calculateCart(cartDTO);
    }

}
