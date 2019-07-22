package com.siteware.ecommerce.validator.product;

import com.siteware.ecommerce.exception.PropertyError;
import com.siteware.ecommerce.exception.ValidationException;
import com.siteware.ecommerce.pojo.product.Product;
import org.springframework.stereotype.Component;

/**
 * Validates a Product.
 *
 * @author Antunes Dantas
 */
@Component
public class ProductValidator {

    public void validateProduct(Product product) {
        if (product.getName() == null) {
            throw new ValidationException(new PropertyError("name").missingProperty());
        }

        if (product.getPricing() == null) {
            throw new ValidationException(new PropertyError("price").missingProperty());
        }

        if (product.getPricing() < 0) {
            throw new ValidationException(new PropertyError("price").missingProperty());
        }
    }

}
