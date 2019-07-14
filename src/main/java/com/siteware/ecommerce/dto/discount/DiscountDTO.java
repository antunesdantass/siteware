package com.siteware.ecommerce.dto.discount;

import com.siteware.ecommerce.service.discount.Discount;

import java.io.Serializable;

/**
 * DTO with details of Discount
 */
public class DiscountDTO implements Serializable {

    private static final long serialVersionUID = 7039628947380559052L;

    private Discount discount;

    public DiscountDTO(Discount discount) {
        this.discount = discount;
    }

    public String getName() {
        return discount.getName();
    }

    public String getDescription() {
        return discount.getDescription();
    }

    public Discount getDiscount() {
        return discount;
    }
}
