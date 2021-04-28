package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.entity.Customer;
import com.enigma.challengegoldpocket.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CustomMailSender implements MailSender {
    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendEmail(Customer customer, Purchase purchase) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(customer.getEmail());
        message.setSubject("INVOICE GOLD POCKET");
        message.setText("Berhasil melakukan pembelian !");
        javaMailSender.send(message);
    }
}
