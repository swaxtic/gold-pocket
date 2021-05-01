package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.dto.PurchaseDto;
import com.enigma.challengegoldpocket.entity.Customer;
import com.enigma.challengegoldpocket.entity.Pocket;
import com.enigma.challengegoldpocket.entity.Purchase;
import com.enigma.challengegoldpocket.entity.PurchaseDetail;
import com.enigma.challengegoldpocket.repository.PurchaseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpMethod;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    PocketService pocketService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MailSender mailSender;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Autowired
    WalletServices walletServices;


    @Override
    public Purchase findPurchaseById(String id) {
        return purchaseRepository.findById(id).get();
    }

    @Override
    public Page<Purchase> findPurchases(PageRequest pageRequest) {
        return purchaseRepository.findAll(pageRequest);
    }

    @Override
    public Purchase purchase(Purchase purchase, String customerId) throws JsonProcessingException {
        Customer customer = customerService.findCustomerById(customerId);
        purchase.setCustomer(customer);
        purchase.setPurchaseDate(new Date());

        BigDecimal total = new BigDecimal(0.0);
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
                BigDecimal quantity = new BigDecimal(purchaseDetail.getQuantityInGram());
                total = total.add(purchaseDetail.getPrice().multiply(quantity));
            }

            walletServices.debetToWallet(customer, total);

            PurchaseDto purchaseDto = new PurchaseDto();
            purchaseDto.setEmailTo(customer.getEmail());
            purchaseDto.setCustomerName(customer.getFirstName()+" "+customer.getLastName());
            purchaseDto.setTotal(total);

            String jsonPurchase = objectMapper.writeValueAsString(purchaseDto);
            //mailSender.sendEmail(customer, purchase);
            kafkaTemplate.send("simple-notification",jsonPurchase);
        }
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase updatePurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
