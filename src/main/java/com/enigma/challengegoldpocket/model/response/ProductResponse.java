package com.enigma.challengegoldpocket.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private String id;
    private String productName;
    private BigDecimal productPriceBuy;
    private BigDecimal productPriceSell;
    private String productImage;
    private Integer productStatus;
    private Date createdAt;
    private Date updatedAt;

}
