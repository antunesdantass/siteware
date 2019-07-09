package com.siteware.ecommerce.pojo.product;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Product entity, responsible for modeling how a product is in the system.
 *
 * @author Antunes Dantas
 */
@Entity
@Table(name = "TB_PRODUCT")
public class Product {

    private Long id;

    private String name;

    private Double pricing;

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

    public Double getPricing() {
        return pricing;
    }

    public void setPricing(Double pricing) {
        this.pricing = pricing;
    }
}
