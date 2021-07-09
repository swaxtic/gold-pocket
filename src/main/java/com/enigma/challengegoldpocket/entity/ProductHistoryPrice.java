package com.enigma.challengegoldpocket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "m_history_prices")
public class ProductHistoryPrice {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Column(name = "history_date")
    private Date historyDate;

    @Column(name = "price_buy")
    private BigDecimal priceBuy;

    @Column(name = "price_sell")
    private BigDecimal priceSell;

//    @Transient
//    private String productId;

    @ManyToOne
    @JoinColumn(name = "product_id") //nama field yg menjadi foreign key
    @JsonIgnore // mengabaikan product
//    @JsonIgnoreProperties({"product"}) //ignoer pada entity product
    private Product product;

    //men set kolom yg sama
    public ProductHistoryPrice(Product product) {
        this.historyDate = product.getUpdatedAt();
        this.priceBuy = product.getProductPriceBuy();
        this.priceSell = product.getProductPriceSell();
        this.product = product;
    }

    public ProductHistoryPrice() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getHistoryDate() {
        return historyDate;
    }

    public void setHistoryDate(Date historyDate) {
        this.historyDate = historyDate;
    }

    public BigDecimal getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(BigDecimal priceBuy) {
        this.priceBuy = priceBuy;
    }

    public BigDecimal getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(BigDecimal priceSell) {
        this.priceSell = priceSell;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}

