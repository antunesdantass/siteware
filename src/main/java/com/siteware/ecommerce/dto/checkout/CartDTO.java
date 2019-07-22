package com.siteware.ecommerce.dto.checkout;

import java.io.Serializable;
import java.util.List;

/**
 * This entity represents a Cart on the system, which is
 * composed by a List of Sales.
 *
 * @author Antunes Dantas
 */
public class CartDTO implements Serializable {

    private static final long serialVersionUID = -3961353276520845091L;

    private List<CartItemDTO> items;

    private Double total;

    public CartDTO() { }

    public CartDTO(List<CartItemDTO> items, Double total) {
        this.items = items;
        this.total = total;
    }

    public List<CartItemDTO> getItems() {
        return items;
    }

    public void setItems(List<CartItemDTO> items) {
        this.items = items;
    }

    public Double getTotal() {
        return items.stream().map(cartItemDTO -> cartItemDTO.getTotalPrice())
                .reduce(0.0, Double::sum);
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
