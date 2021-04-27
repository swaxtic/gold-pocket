package com.enigma.challengegoldpocket.controller;

import com.enigma.challengegoldpocket.dto.CustomerSearchDto;
import com.enigma.challengegoldpocket.entity.Customer;
import com.enigma.challengegoldpocket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") String id){
        return customerService.findCustomerById(id);
    }
    //PostMapping
    //convention name untuk rest API
    //tergantung kesepakatan perusahaan
//    @GetMapping("/customers") //pathvariable, harus sama dgn name di Anotation
//    public List<Customer> getCustomers(){
//        return customerService.findCustomers();
//    }
//    @GetMapping("/customers") //pathvariable, harus sama dgn name di Anotation
//    public List<Customer> getCustomers(@RequestParam(name = "firstName", defaultValue = "") String firstName,
//                                       @RequestParam(name = "email", defaultValue = "") String email,
//                                       @RequestParam(name = "page", defaultValue = "0") Integer page,
//                                       @RequestParam(name = "size", defaultValue = "5") Integer size,
//                                       @RequestParam(name = "startDate")Date startDate,
//                                       @RequestParam(name = "endDate") Date endDate){
//        Pageable pageable = PageRequest.of(page,size);
//        return customerService.findCustomers(firstName, email,startDate,endDate, pageable);
//    }
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
}
