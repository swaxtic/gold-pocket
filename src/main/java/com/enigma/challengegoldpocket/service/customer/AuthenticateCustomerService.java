package com.enigma.challengegoldpocket.service.customer;

import com.enigma.challengegoldpocket.model.request.CustomerRequest;
import com.enigma.challengegoldpocket.model.response.CustomerResponse;
import com.enigma.challengegoldpocket.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthenticateCustomerService{

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse execute(CustomerRequest data){
       return this.customerRepository.getUserByEmailAndPassword(data.getEmail(), data.getPassword()).map(customer ->
                CustomerResponse.builder()
                        .id(customer.getId())
                        .email(customer.getEmail())
                        .username(customer.getUsername())
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .status(true)
                        .build()).orElseThrow(() -> {
           throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
       });
    }
}
