package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.entity.Pocket;

public interface PocketService {
    public Pocket findPocketById(String id);
    //public Page<Customer> findCustomers(CustomerSearchDto customerSearchForm, Pageable pageable);
    public Pocket createNewPocket(Pocket pocket);
    public Pocket updatePocket(Pocket pocket);
    public void topUp(Pocket pocket, Double qty);
    //public void removeCustomer(String id);
}
