package com.enigma.challengegoldpocket.dto;

import java.util.Date;

public class ProductHistorySearchDto {
    private String id;
    private Date historyDate;
    private Integer priceBuy;
    private Integer priceSell;
    private String productId;

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

    public Integer getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(Integer priceBuy) {
        this.priceBuy = priceBuy;
    }

    public Integer getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(Integer priceSell) {
        this.priceSell = priceSell;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
