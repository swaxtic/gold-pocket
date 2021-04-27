package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.entity.ProductHistoryPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductHistoryPriceService {
    public ProductHistoryPrice createHistory(ProductHistoryPrice productHistoryPrice);
    public List<ProductHistoryPrice> findAllByProduct(String id);
    public Page<ProductHistoryPrice> findHistory(Pageable pageable);
}
