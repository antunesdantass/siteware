package com.siteware.ecommerce.pojo.checkout;

import com.siteware.ecommerce.pojo.sale.Sale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * This entity represents a Cart on the system, which is
 * composed by a List of Sales.
 *
 * @author Antunes Dantas
 */
@Entity
@Table(name = "TB_CART")
public class Cart implements Serializable {

    private static final long serialVersionUID = -3961353276520845091L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToMany(mappedBy = "TB_CART", fetch = FetchType.EAGER)
    private List<Sale> items;

    public Cart() { }

    public Cart(List<Sale> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Sale> getItems() {
        return items;
    }

    public void setItems(List<Sale> items) {
        this.items = items;
    }
}
