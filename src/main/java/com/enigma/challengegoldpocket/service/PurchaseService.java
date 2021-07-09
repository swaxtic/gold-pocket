package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.entity.Purchase;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface PurchaseService {
    public Purchase findPurchaseById(String id);
    public Page<Purchase> findPurchases(PageRequest pageRequest);
    public List<Purchase> findPurchasesByCustomer(String customerId);
    public Purchase purchase(Purchase purchase, String customerId) throws JsonProcessingException;
    public Purchase updatePurchase(Purchase purchase);
    //public void removeCustomer(String id);
}
