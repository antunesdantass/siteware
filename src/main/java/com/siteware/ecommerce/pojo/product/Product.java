package com.siteware.ecommerce.pojo.product;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

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
    @Column(name = "ID_PRODUCT")
    private Long id;

    @Column(name = "NO_NAME")
    @Length(max = 500)
    @NotNull
    private String name;

    @Column(name = "NR_PRICING")
    @NotNull
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
