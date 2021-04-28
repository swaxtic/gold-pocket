package com.enigma.challengegoldpocket.service;


import com.enigma.challengegoldpocket.entity.Customer;
import com.enigma.challengegoldpocket.entity.Purchase;

public interface MailSender {
    public void sendEmail(Customer customer, Purchase purchase);
}
