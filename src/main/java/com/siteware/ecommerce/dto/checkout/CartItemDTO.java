package com.siteware.ecommerce.dto.checkout;

import com.siteware.ecommerce.pojo.product.Product;

import java.io.Serializable;

/**
 * This class represents an Item in the Cart.
 *
 * @author Antunes Dantas
 */
public class CartItemDTO implements Serializable {

    private static final long serialVersionUID = 7747045661575870791L;

    private Product item;

    private Integer quantity;

    public CartItemDTO() {}

    public CartItemDTO(Product item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return item.getPricing(quantity);
    }
}
