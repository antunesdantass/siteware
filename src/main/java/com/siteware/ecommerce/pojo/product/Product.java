package com.siteware.ecommerce.pojo.product;

import com.siteware.ecommerce.service.discount.Discount;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

/**
 * Product entity, responsible for modeling how a product is in the system.
 *
 * @author Antunes Dantas
 */
@Entity
@Table(name = "TB_PRODUCT")
public class Product implements Serializable {

    private static final long serialVersionUID = -265665862922221302L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NO_NAME")
    @Length(max = 500)
    @NotNull
    private String name;

    @Column(name = "NR_PRICING")
    @NotNull
    private Double pricing;

    @Column(name = "FK_DISCOUNT")
    private Discount discount;

    public Product() {}

    public Product(String name, Double pricing) {
        this.name = name;
        this.pricing = pricing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Calculates the price for the Sale with the amount requested.
     * If there's no Discount associated with the Product, it's calculated
     * the price per item.
     *
     * @param quantity amount of item's to be purchased.
     *
     * @return the total price for the amount requested.
     */
    public Double getPricing(Integer quantity) {
        Optional<Discount> discount = Optional.ofNullable(getDiscount());

        return discount.map(disc -> disc.calculatePrice(pricing, quantity))
                .orElse(pricing * quantity);
    }

    public Double getPricing() {
        return getPricing(1);
    }

    public void setPricing(Double pricing) {
        this.pricing = pricing;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
