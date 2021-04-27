package com.enigma.challengegoldpocket.repository;

import com.enigma.challengegoldpocket.entity.ProductHistoryPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductHistoryPriceRepository extends JpaRepository<ProductHistoryPrice, String> {
}
