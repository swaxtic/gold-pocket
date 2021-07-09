package com.enigma.challengegoldpocket;

import com.enigma.challengegoldpocket.entity.Customer;
import com.enigma.challengegoldpocket.entity.Product;
import com.enigma.challengegoldpocket.repository.CustomerRepository;
import com.enigma.challengegoldpocket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class NativeQueryRunner implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        //List<Customer> customers = customerRepository.findActiveCustomer(1);
        //List<Customer> customers = customerRepository.findActiveCustomerNative();

        //List<Product> products = productRepository.findAllProductWithGreaterThan(new BigDecimal(800000),1);

        //List<Product> products = productRepository.finAll();

        //customers.stream().forEach(customer -> System.out.println(customer));
        //products.stream().forEach(product -> System.out.println(product.getProductHistories()));

        //projection
        productRepository.prices().forEach(prices -> System.out.println(prices.getProductPriceSell()+"||"+prices.getProductBuySell()));
    }
}
