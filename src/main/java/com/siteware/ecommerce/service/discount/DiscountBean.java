package com.siteware.ecommerce.service.discount;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DiscountBean implements DiscountService {

    @Override
    public List<Discount> getDiscounts() {
        return Arrays.asList(Discount.values());
    }
}
