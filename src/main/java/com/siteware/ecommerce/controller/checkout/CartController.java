package com.siteware.ecommerce.controller.checkout;

import com.siteware.ecommerce.business.cart.CartBusinessDelegate;
import com.siteware.ecommerce.dto.checkout.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartBusinessDelegate cartBusinessDelegate;

    @PostMapping
    public CartDTO calculateCart(@RequestBody CartDTO cartDTO) {
        return cartBusinessDelegate.calculateCart(cartDTO);
    }

}
