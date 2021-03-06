package com.enigma.challengegoldpocket.service;

import com.enigma.challengegoldpocket.entity.Pocket;
import com.enigma.challengegoldpocket.model.response.BaseResponse;

import java.util.Set;

public interface PocketService {
    public Pocket findPocketById(String id);
    public Pocket createNewPocket(Pocket pocket);
    public Pocket updatePocket(Pocket pocket);
    public Set<Pocket> customerPockets(String id);
    public void sell(Pocket pocket, Double qty);
    public void topUp(Pocket pocket, Double qty);
    public BaseResponse deletePocket(String id);
    //public void removeCustomer(String id);
}
