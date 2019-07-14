package com.siteware.ecommerce.controller.discount;

import com.siteware.ecommerce.dto.discount.DiscountDTO;
import com.siteware.ecommerce.service.discount.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller which provides access to the methods
 * available for the Discount entity.
 *
 * @author Antunes Dantas
 */
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
    public List<DiscountDTO> getDiscounts() {
        return discountService.getDiscounts();
    }

}
