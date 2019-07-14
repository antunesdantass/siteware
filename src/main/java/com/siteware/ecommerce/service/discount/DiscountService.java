package com.siteware.ecommerce.service.discount;

import com.siteware.ecommerce.dto.discount.DiscountDTO;

import java.util.List;

public interface DiscountService {

    /**
     * Retuns a List with all the Discounts of the system.
     *
     * @return a List with the Discounts.
     */
    List<DiscountDTO> getDiscounts();

}
