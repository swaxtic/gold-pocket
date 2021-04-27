package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.entity.Product;
import com.enigma.challengegoldpocket.entity.ProductHistoryPrice;
import com.enigma.challengegoldpocket.repository.ProductHistoryPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductHistoryPriceServiceImpl implements ProductHistoryPriceService {
    @Autowired
    ProductHistoryPriceRepository productHistoryPriceRepository;

    @Autowired
    ProductService productService;

    @Override
    public ProductHistoryPrice createHistory(ProductHistoryPrice productHistoryPrice) {
        return productHistoryPriceRepository.save(productHistoryPrice);
    }

    @Override
    public List<ProductHistoryPrice> findAllByProduct(String id) {
        Product product = productService.getProductById(id);
        return product.getProductHistories();
    }

    @Override
    public Page<ProductHistoryPrice> findHistory(Pageable pageable) {
        return productHistoryPriceRepository.findAll(pageable);
    }

}
