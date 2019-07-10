package com.siteware.ecommerce.service.discount;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Enumerator which contains all the Discounts of the system.
 *
 * @author Antunes Dantas
 */
public enum Discount {

    DEFAULT ("Default", "Promoção default", DiscountFunctions.DEFAULT),

    TRES_POR_10 ("Três por 10", DiscountDescriptions.TRES_POR_10, DiscountFunctions.TRES_POR_10),

    PAGUE_UM_LEVE_DOIS ("Pague Um Leve Dois", DiscountDescriptions.PAGUE_UM_LEVE_DOIS, DiscountFunctions.PAGUE_UM_LEVE_DOIS);

    private final String name;

    private final String description;

    private final BiFunction<Double, Integer, Double> discountFunction;

    /**
     * Private constructor for Discount. There are separeted files for the description and
     * functions, aiming to reduce the size of this file.
     *
     * @param name The name of the Discount.
     *
     * @param description Description of how the Discount works.
     *
     * @param discountFunction a Function which takes two arguments, the item's price and
     *                         the amount on the cart and returns the value for those items.
     */
    private Discount(String name,
                     String description,
                     BiFunction<Double, Integer, Double> discountFunction) {
        this.name = name;
        this.description = description;
        this.discountFunction = discountFunction;
    }

    /**
     * Returns the Discount function for a specified Discount.
     * If there's no Discount with the provided name, the default Descount
     * is returned.
     *
     * @param name Name of the Discount.
     *
     * @return The Discount function.
     */
    public static BiFunction<Double, Integer, Double> getDiscount(String name) {
        Discount[] discounts = Discount.values();
        return Arrays.stream(discounts).filter(discount -> discount.name.equals(name)).findFirst()
                .get().discountFunction;
    }
}
