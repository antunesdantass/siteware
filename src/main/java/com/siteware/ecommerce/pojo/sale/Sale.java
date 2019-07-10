package com.siteware.ecommerce.pojo.sale;

import com.siteware.ecommerce.pojo.product.Product;
import com.siteware.ecommerce.service.discount.Discount;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * A Sale is an entity which encapsulates a Product and a Discount, making it
 * possible to have many sale campaigns for the same Product.
 *
 * @author Antunes Dantas
 */
@Entity
@Table(name = "TB_SALE")
public class Sale implements Serializable {

    private static final long serialVersionUID = -5640656575211229324L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @Column(name = "FK_PRODUCT")
    private Product product;

    @Column(name = "FK_DISCOUNT")
    private Discount discount;

    public Sale() {}

    public Sale(Product product, Discount discount) {
        this.product = product;
        this.discount = discount;
    }

    @PrePersist
    public void prePersist() {
        if (discount == null) {
            this.discount = Discount.DEFAULT;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
