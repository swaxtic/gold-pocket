package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.entity.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface PurchaseService {
    public Purchase findPurchaseById(String id);
    public Page<Purchase> findPurchases(PageRequest pageRequest);
    public Purchase purchase(Purchase purchase, String customerId);
    public Purchase updatePurchase(Purchase purchase);
    //public void removeCustomer(String id);
}
