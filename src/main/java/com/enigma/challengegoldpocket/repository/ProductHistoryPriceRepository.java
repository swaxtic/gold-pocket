package com.enigma.challengegoldpocket.repository;

import com.enigma.challengegoldpocket.entity.Product;
import com.enigma.challengegoldpocket.entity.ProductHistoryPrice;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductHistoryPriceRepository extends JpaRepository<ProductHistoryPrice, String>{

}
