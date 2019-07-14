package com.siteware.ecommerce.controller.discount;

import com.siteware.ecommerce.service.discount.Discount;
import com.siteware.ecommerce.service.discount.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    /**
     * Request all the Discounts of the system.
     *
     * @return a List with all the Discounts.
     */
    @GetMapping
    public List<Discount> getDiscounts() {
        return discountService.getDiscounts();
    }

}
