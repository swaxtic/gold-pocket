package com.enigma.challengegoldpocket.dto;

import java.util.Date;

public class ProductSearchDto {
    private String id;
    private String productName;
    private Integer productPriceBuy;
    private Integer productPriceSell;
    private String productImage;
    private Integer productStatus;
    private Date createdAt;
    private Date updateAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPriceBuy() {
        return productPriceBuy;
    }

    public void setProductPriceBuy(Integer productPriceBuy) {
        this.productPriceBuy = productPriceBuy;
    }

    public Integer getProductPriceSell() {
        return productPriceSell;
    }

    public void setProductPriceSell(Integer productPriceSell) {
        this.productPriceSell = productPriceSell;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
