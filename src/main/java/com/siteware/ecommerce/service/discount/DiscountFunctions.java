package com.siteware.ecommerce.service.discount;

import java.util.function.BiFunction;

/**
 * Implementations of the Discount functions.
 * All the functions must be implemented as follows: it takes two arguments:
 *      A Double (the item's price) and an Integer (the amount of items of the type in the cart).
 *      The return must be a Double, the value which the items will be charged of.
 *
 * @author Antunes Dantas
 */
public class DiscountFunctions {

    /**
     * Default function for Discount. It does nothing but calculates the total pricing
     * of items.
     */
    public static final BiFunction<Double, Integer, Double> DEFAULT = (pricing, quantity) -> pricing * quantity;

    /**
     * This Discount applies when three item's are chosed, they will cost RS 10,00, no matter
     * what's the price for the item. If the amount of item's is not a multiple of three, the
     * rest of them will be charged individually.
     */
    public static final BiFunction<Double, Integer, Double> TRES_POR_10 = (pricing, quantity) -> {
        final Double discountPrice = 10.0;
        final Integer amountForDiscount = 3;
        final Integer quantityElegible = (quantity - (quantity % amountForDiscount)) / amountForDiscount;
        final Integer quantityNotElegible = quantity % amountForDiscount;
        return quantityElegible * discountPrice + quantityNotElegible * pricing;
    };

    /**
     * This Discount works by giving for free the second item chose of the same kind.
     */
    public static final BiFunction<Double, Integer, Double> PAGUE_UM_LEVE_DOIS = (pricing, quantity) -> {
        final Integer amountForDiscount = 2;
        final Integer quantityElegible = (quantity - 1) / amountForDiscount;
        return quantityElegible * pricing + pricing;
    };
}
