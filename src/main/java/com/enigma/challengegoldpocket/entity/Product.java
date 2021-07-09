package com.enigma.challengegoldpocket.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}

