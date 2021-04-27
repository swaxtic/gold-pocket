package com.enigma.challengegoldpocket.controller;

import com.enigma.challengegoldpocket.dto.CustomerSearchDto;
import com.enigma.challengegoldpocket.entity.Customer;
import com.enigma.challengegoldpocket.entity.Pocket;
import com.enigma.challengegoldpocket.entity.ProductHistoryPrice;
import com.enigma.challengegoldpocket.service.CustomerService;
import com.enigma.challengegoldpocket.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    @Autowired
    PocketService pocketService;

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") String id){
        return customerService.findCustomerById(id);
    }
    @GetMapping("/customers")
    public Page<Customer> getCustomers(@RequestBody CustomerSearchDto customerSearchFrom,
                                       @RequestParam(name = "page", defaultValue = "0") Integer page,
                                       @RequestParam(name = "size", defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return customerService.findCustomers(customerSearchFrom, pageable);
    }
    @PostMapping("/customer")
    public void addNewCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @PutMapping("/customer")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomerById(@PathVariable(name = "id") String id){
        customerService.removeCustomer(id);
    }

    @GetMapping("/customer/{id}/pockets")
    public Set<Pocket> getCustomerPockets(@PathVariable(name = "id") String id){
        return pocketService.customerPockets(id);
    }
}
