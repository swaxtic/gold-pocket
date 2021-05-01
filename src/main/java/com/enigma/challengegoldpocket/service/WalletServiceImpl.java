package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.constant.AppConfigConstant;
import com.enigma.challengegoldpocket.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

@Service
public class WalletServiceImpl implements WalletServices{

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AppConfigService appConfigService;

    @Override
    public void debetToWallet(Customer customer, BigDecimal total) {
        UriComponentsBuilder componentsBuilder = UriComponentsBuilder
                .fromHttpUrl(appConfigService.getValue(AppConfigConstant.OPO_WALLET_ENDPOINT_URL))
                .queryParam("phoneNumber",customer.getPhoneNumber())
                .queryParam("amount",total);
        System.out.println("Total Amount = "+total);
        System.out.println(componentsBuilder.toString());
        restTemplate.exchange(componentsBuilder.toUriString(), HttpMethod.POST, null,String.class);
    }
}
