package com.enigma.challengegoldpocket.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "m_products") ///m (master) t(transaksi) l(logging)
public class Product {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    //hybird naming strategy
    //firstN first_n
    private String productName; // bisa uto detect jadi snake
    private BigDecimal productPriceBuy;
    private BigDecimal productPriceSell;
    private String productImage;
    private Integer productStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @OneToMany(mappedBy = "product")//aku disebut di product histori sebagai apa
    private List<ProductHistoryPrice> productHistories = new ArrayList<>();

    public List<ProductHistoryPrice> getProductHistories() {
        return productHistories;
    }

    public void setProductHistories(List<ProductHistoryPrice> productHistories) {
        this.productHistories = productHistories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPriceBuy() {
        return productPriceBuy;
    }

    public void setProductPriceBuy(BigDecimal productPriceBuy) {
        this.productPriceBuy = productPriceBuy;
    }

    public BigDecimal getProductPriceSell() {
        return productPriceSell;
    }

    public void setProductPriceSell(BigDecimal productPriceSell) {
        this.productPriceSell = productPriceSell;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + id +
                ", createdAt=" + createdAt +
                ", productImage='" + productImage + '\'' +
                ", productName='" + productName + '\'' +
                ", productPriceBuy=" + productPriceBuy +
                ", productPriceSell=" + productPriceSell +
                ", productStatus=" + productStatus +
                ", updateAt=" + updatedAt +
                '}';
    }

}

