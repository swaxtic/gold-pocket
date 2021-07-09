package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.entity.Customer;
import com.enigma.challengegoldpocket.entity.Pocket;
import com.enigma.challengegoldpocket.entity.Product;
import com.enigma.challengegoldpocket.entity.ProductHistoryPrice;
import com.enigma.challengegoldpocket.model.response.BaseResponse;
import com.enigma.challengegoldpocket.repository.PocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@Service
public class PocketServiceImpl implements PocketService{
    @Autowired
    PocketRepository pocketRepository;

    @Autowired
    CustomerService customerService;

    @Override
    public Pocket findPocketById(String id) {
        return pocketRepository.findById(id).get();
    }

    @Override
    public Pocket createNewPocket(Pocket pocket) {
        pocket.setPocketQty(0.0);
        return pocketRepository.save(pocket);
    }

    @Override
    public Pocket updatePocket(Pocket pocket) {
        return pocketRepository.save(pocket);
    }

    @Override
    public void topUp(Pocket pocket, Double qty) {
        pocket.setPocketQty(pocket.getPocketQty()+qty);
        pocketRepository.save(pocket);
    }

    @Override
    public BaseResponse deletePocket(String id) {
        this.pocketRepository.findById(id).ifPresentOrElse(data -> {
            this.pocketRepository.delete(data);
        }, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Not Found");
        });
        return BaseResponse.builder().message("Pocket Berhasil di Hapus").result(true).build();
    }

    @Override
    public void sell(Pocket pocket, Double qty) {
        pocket.setPocketQty(pocket.getPocketQty()-qty);
        pocketRepository.save(pocket);
    }

    @Override
    public Set<Pocket> customerPockets(String id) {
        Customer customer = customerService.findCustomerById(id);
        return customer.getPockets();
    }
}
