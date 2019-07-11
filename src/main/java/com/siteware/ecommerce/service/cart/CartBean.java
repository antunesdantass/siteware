package com.siteware.ecommerce.service.cart;

import com.siteware.ecommerce.dao.cart.CartDAO;
import com.siteware.ecommerce.pojo.checkout.Cart;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

/**
 * Implementation of the CartService interface.
 *
 * @author Antunes Dantas
 */
@Transactional
public class CartBean implements CartService {

    @Autowired
    CartDAO cartDAO;

    @Override
    public Cart createCart(Cart cart) {
        cartDAO.persistCart(cart);

        return cartDAO.findCartById(cart.getId());
    }

    @Override
    public Cart getCart(Long id) {
        return cartDAO.findCartById(id);
    }

    @Override
    public Cart updateCart(Cart cart) {
        return cartDAO.updateCart(cart);
    }

    @Override
    public void deleteCart(Long id) {
        cartDAO.deleteCart(id);
    }
}
