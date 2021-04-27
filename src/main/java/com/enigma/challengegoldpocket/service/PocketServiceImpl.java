package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.entity.Pocket;
import com.enigma.challengegoldpocket.repository.PocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PocketServiceImpl implements PocketService{
    @Autowired
    PocketRepository pocketRepository;

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
}
