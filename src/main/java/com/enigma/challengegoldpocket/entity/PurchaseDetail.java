package com.enigma.challengegoldpocket.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_purchase_details")
public class PurchaseDetail {
    @Id
    @Column(name = "purchase_detail_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private BigDecimal price;
    private Double quantityInGram;

    @ManyToOne //banyak detail satu product
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties({"productHistories"})
    private Product product;
    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;
    @ManyToOne
    @JoinColumn(name = "pocket_id")
    @JsonIgnoreProperties({"product"})
    private Pocket pocket;

    public Pocket getPocket() {
        return pocket;
    }

    public void setPocket(Pocket pocket) {
        this.pocket = pocket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getQuantityInGram() {
        return quantityInGram;
    }

    public void setQuantityInGram(Double quantityInGram) {
        this.quantityInGram = quantityInGram;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
