package com.siteware.ecommerce.service.discount;

import java.util.List;

public interface DiscountService {

    /**
     * Retuns a List with all the Discounts of the system.
     *
     * @return a List with the Discounts.
     */
    public List<Discount> getDiscounts();

}
