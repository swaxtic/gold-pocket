package com.enigma.challengegoldpocket.controller;

import com.enigma.challengegoldpocket.dto.WalletDto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.util.function.Supplier;
import java.util.logging.Logger;

@RestController
public class Coba {

//    Logger logger = (Logger) LoggerFactory.getLogger(Coba.class);
//
//    @Autowired
//    RestTemplate restTemplate;

//    @GetMapping("/coba")
//    public ResponseEntity<WalletDto> getCoba(){
//        WalletDto walletDto = new WalletDto("189718971897", BigDecimal.ZERO);
//        ResponseEntity<WalletDto> response = restTemplate.postForEntity(URI.create("http://localhost:8098/"),walletDto,WalletDto.class);
//        System.out.println(response.getBody());
//        logger.info(response.getBody());
//        return response;
//    }
}
