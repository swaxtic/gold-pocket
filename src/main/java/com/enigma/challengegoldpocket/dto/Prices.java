package com.enigma.challengegoldpocket.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Prices {

    private BigDecimal productPriceSell;
    private BigDecimal productBuySell;

    public Prices(BigDecimal productPriceSell, BigDecimal productBuySell) {
        this.productPriceSell = productPriceSell;
        this.productBuySell = productBuySell;
    }

    public BigDecimal getProductPriceSell() {
        return productPriceSell;
    }

    public void setProductPriceSell(BigDecimal productPriceSell) {
        this.productPriceSell = productPriceSell;
    }

    public BigDecimal getProductBuySell() {
        return productBuySell;
    }

    public void setProductBuySell(BigDecimal productBuySell) {
        this.productBuySell = productBuySell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prices prices = (Prices) o;
        return Objects.equals(productPriceSell, prices.productPriceSell) && Objects.equals(productBuySell, prices.productBuySell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productPriceSell, productBuySell);
    }
}
