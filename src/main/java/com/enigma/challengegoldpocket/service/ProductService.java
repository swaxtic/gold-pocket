package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.dto.ProductSearchDto;
import com.enigma.challengegoldpocket.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    public Product getProductById(String id);
    public Page<Product> searchProduct(ProductSearchDto productSearchForm,Pageable page);
    //public void saveProduct(Product product, ProductHistoryPrice productHistoryPrice);
    public Product saveProduct(Product product);
    public Product updateProduct(Product product);


}
