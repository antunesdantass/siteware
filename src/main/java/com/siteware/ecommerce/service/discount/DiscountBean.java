package com.siteware.ecommerce.service.discount;

import com.siteware.ecommerce.dto.discount.DiscountDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountBean implements DiscountService {

    @Override
    public List<DiscountDTO> getDiscounts() {
        return Arrays.asList(Discount.values()).stream()
                .map(discount -> new DiscountDTO(discount)).collect(Collectors.toList());
    }
}
