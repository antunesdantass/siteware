package com.siteware.ecommerce.business.cart;

import com.siteware.ecommerce.dto.checkout.CartDTO;
import com.siteware.ecommerce.dto.checkout.CartItemDTO;
import com.siteware.ecommerce.pojo.product.Product;
import com.siteware.ecommerce.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Provides business logic for the Cart
 *
 * @author Antunes Dantas
 */
@Service
public class CartBusinessDelegate {

    @Autowired
    private ProductService productService;

    /**
     * Just returns the Cart because Jackson (the parser for JSON)
     * will automatically calculate the total amount.
     *
     * @param cart A Cart with the item's.
     *
     * @return The Cart with the total price calculated.
     */
    public CartDTO calculateCart(CartDTO cart) {
        List<CartItemDTO> items = loadItems(cart.getItems());
        return new CartDTO(items);
    }

    /**
     * Retrives the products from the database.
     *
     * @param items Items to be searched.
     *
     * @return a new List for the CartItems with the Products from the database.
     */
    private List<CartItemDTO> loadItems(final List<CartItemDTO> items) {
        List<Long> productsId = items.stream()
                .map(cartItemDTO -> cartItemDTO.getItem().getId()).collect(Collectors.toList());

        Map<Long, List<Product>> products = productService.getProductsById(productsId)
                .stream().collect(Collectors.groupingBy(Product::getId));

        return items.stream().map(item -> {
            Product product = products.get(item.getItem().getId()).stream().findFirst().get();
            return new CartItemDTO(product, item.getQuantity());
        }).collect(Collectors.toList());
    }
}
