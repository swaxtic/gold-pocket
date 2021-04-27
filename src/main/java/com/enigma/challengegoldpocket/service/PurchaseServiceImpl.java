package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.entity.Customer;
import com.enigma.challengegoldpocket.entity.Pocket;
import com.enigma.challengegoldpocket.entity.Purchase;
import com.enigma.challengegoldpocket.entity.PurchaseDetail;
import com.enigma.challengegoldpocket.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    PocketService pocketService;


    @Override
    public Purchase findPurchaseById(String id) {
        return purchaseRepository.findById(id).get();
    }

    @Override
    public Page<Purchase> findPurchases(PageRequest pageRequest) {
        return purchaseRepository.findAll(pageRequest);
    }

    @Override
    public Purchase purchase(Purchase purchase, String customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        purchase.setCustomer(customer);
        purchase.setPurchaseDate(new Date());

        if (purchase.getPurchaseType()==1){
            for (PurchaseDetail purchaseDetail: purchase.getPurchaseDetails()) {
                Pocket pocket = pocketService.findPocketById(purchaseDetail.getPocket().getId()); //
                pocketService.sell(pocket, purchaseDetail.getQuantityInGram());
                purchaseDetail.setProduct(pocket.getProduct());
                purchaseDetail.setPrice(pocket.getProduct().getProductPriceBuy());
                purchaseDetail.setPurchase(purchase);
            }
        }else if(purchase.getPurchaseType()==0){
            for (PurchaseDetail purchaseDetail: purchase.getPurchaseDetails()) {
                Pocket pocket = pocketService.findPocketById(purchaseDetail.getPocket().getId());
                pocketService.topUp(pocket, purchaseDetail.getQuantityInGram());
                purchaseDetail.setProduct(pocket.getProduct());
                purchaseDetail.setPrice(pocket.getProduct().getProductPriceSell());
                purchaseDetail.setPurchase(purchase);
            }
        }
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase updatePurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
