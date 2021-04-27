package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.dto.ProductSearchDto;
import com.enigma.challengegoldpocket.entity.Product;
import com.enigma.challengegoldpocket.entity.ProductHistoryPrice;
import com.enigma.challengegoldpocket.repository.ProductRepository;
import com.enigma.challengegoldpocket.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductHistoryPriceService productHistoryPriceService;

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Page<Product> searchProduct(ProductSearchDto productSearchForm, Pageable pageable) {
        return productRepository.findAll(ProductSpecification.findProducts(productSearchForm), pageable);
    }

//    @Override
//    public void saveProduct(Product product, ProductHistoryPrice productHistoryPrice) {
//        //productRepository.save(product);
//        product.getProductHistories().add(productHistoryPrice);
//        productRepository.save(product);
//    }


        @Override
    public Product saveProduct(Product product) {
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());
        //simpan prduct
        Product savedProduct = productRepository.save(product);
        //simpan ke history
        ProductHistoryPrice productHistoryPrice = new ProductHistoryPrice(savedProduct);
        productHistoryPriceService.createHistory(productHistoryPrice);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product product) {
        product.setCreatedAt(product.getCreatedAt());
        product.setUpdatedAt(new Date());
        //simpan product
        Product savedProduct = productRepository.save(product);
        //simpan history
        ProductHistoryPrice productHistoryPrice = new ProductHistoryPrice(savedProduct);
        productHistoryPriceService.createHistory(productHistoryPrice);
        return savedProduct;
    }
}
