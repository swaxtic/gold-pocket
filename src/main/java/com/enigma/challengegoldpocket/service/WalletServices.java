package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.entity.Customer;

import java.math.BigDecimal;

public interface WalletServices {
    public void debetToWallet(Customer customer, BigDecimal total);
}
