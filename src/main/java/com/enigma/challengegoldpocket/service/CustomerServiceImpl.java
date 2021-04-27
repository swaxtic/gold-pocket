package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.dto.CustomerSearchDto;
import com.enigma.challengegoldpocket.entity.Customer;
import com.enigma.challengegoldpocket.repository.CustomerRepository;
import com.enigma.challengegoldpocket.specification.CustomerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final String notFoundMessage = "Customer with id='%s' is Not Found";

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer findCustomerById(String id) {
        validatePresent(id);
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }

    private void validatePresent(String id) {
        if(!customerRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, id));
        }
    }

    @Override
    public Page<Customer> findCustomers(CustomerSearchDto customerSearchForm, Pageable pageable) {
        return customerRepository.findAll(CustomerSpecification.findCustomers(customerSearchForm), pageable);
        //return customerRepository.findAllByFirstNameStartingWithAndEmailContainingAndBirthDateBetween(firstName, email, startDate, endDate, pageable);
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        validatePresent(customer.getId());
        customerRepository.save(customer);
    }

    @Override
    public void removeCustomer(String id) {
        customerRepository.delete(customerRepository.findById(id).get());
    }

}
