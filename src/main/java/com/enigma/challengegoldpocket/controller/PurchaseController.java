package com.enigma.challengegoldpocket.controller;

import com.enigma.challengegoldpocket.entity.Purchase;
import com.enigma.challengegoldpocket.service.PurchaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    @GetMapping("/purchase/{id}")
    public Purchase getPurchaseById(@PathVariable(name = "id") String id){
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
                                    @RequestBody Purchase purchase) throws JsonProcessingException {
        return purchaseService.purchase(purchase,customerId);
    }

    @GetMapping("/purchases/{customerId}")
    public ResponseEntity<?> getPurchasesByCustomer(@PathVariable(name = "customerId") String customerId,
                                                           @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                           @RequestParam(name = "size", defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        List<Purchase> listPurchase = purchaseService.findPurchasesByCustomer(customerId);
        int start = (int)pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), listPurchase.size());
        return ResponseEntity.ok(
                new PageImpl<>(listPurchase.subList(start, end), pageable, listPurchase.size())
        );
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
