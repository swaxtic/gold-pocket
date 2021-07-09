package com.enigma.challengegoldpocket.repository;

import com.enigma.challengegoldpocket.dto.Prices;
import com.enigma.challengegoldpocket.entity.Customer;
import com.enigma.challengegoldpocket.entity.Product;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product , String>, JpaSpecificationExecutor<Product> {
    @Query(value = "SELECT * FROM m_products p WHERE p.product_price_sell > :maxPrice AND p.product_status = :status", nativeQuery = true )
    List<Product> findAllProductWithGreaterThan(@Param("maxPrice") BigDecimal maxPrice,
                                                @Param("status") Integer status);

    @Query(value = "SELECT * FROM m_products", nativeQuery = true)
    List<Product> finAll();

    /// projection
    @Query(value = "SELECT new com.enigma.challengegoldpocket.dto.Prices(p.productPriceSell, p.productPriceBuy) FROM Product  p")
    List<Prices> prices();

    @Query(value="select * from m_products where LOWER(product_name)=:productName", nativeQuery = true)
    Optional<Product> getProductByName(@Param("productName") String productName);

}
