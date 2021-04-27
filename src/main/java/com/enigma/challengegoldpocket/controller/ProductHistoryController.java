package com.enigma.challengegoldpocket.controller;

import com.enigma.challengegoldpocket.entity.ProductHistoryPrice;
import com.enigma.challengegoldpocket.service.ProductHistoryPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductHistoryController {
    @Autowired
    ProductHistoryPriceService productHistoryPriceService;

    @GetMapping("/productsHistory")
    public Page<ProductHistoryPrice> getProducts(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                 @RequestParam(name = "size", defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return productHistoryPriceService.findHistory(pageable);
    }
}
