package com.enigma.challengegoldpocket.controller;

import com.enigma.challengegoldpocket.entity.Purchase;
import com.enigma.challengegoldpocket.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    @GetMapping("/purchase/{id}")
    public Purchase getCustomerById(@PathVariable(name = "id") String id){
        return purchaseService.findPurchaseById(id);
    }

    @GetMapping("/purchases")
    public Page<Purchase> getPurchases(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                       @RequestParam(name = "size", defaultValue = "5") Integer size){
        PageRequest pageRequest = PageRequest.of(page,size);
        return purchaseService.findPurchases(pageRequest);
    }

    @PostMapping("/purchase")
    public Purchase purchase(@RequestParam(name = "customerId") String customerId,
                                    @RequestBody Purchase purchase){
        return purchaseService.purchase(purchase,customerId);
    }
//    @PutMapping("/customer")
//    public Customer updateCustomer(@RequestBody Customer customer){
//        return customerService.updateCustomer(customer);
//    }
//    @DeleteMapping("/customer/{id}")
//    public void deleteCustomerById(@PathVariable(name = "id") String id){
//        customerService.removeCustomer(id);
//    }
//
//    @PostMapping("/customer/{id}/subscription")
//    public void subscribe(@PathVariable(name = "id") String customerId,
//                          @RequestParam(name = "merchantId") String merchantId,
//                          @RequestParam(name = "rate") Integer rate){
//        subscriptionService.subscribe(customerId,merchantId, rate);
//    }
}
