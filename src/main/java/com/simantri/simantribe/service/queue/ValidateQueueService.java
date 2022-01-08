package com.simantri.simantribe.service.queue;

import com.simantri.simantribe.model.request.CreateQueueRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ValidateQueueService {

    public Boolean execute(CreateQueueRequest request) {
        if (request.getRequesterName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Requester name is required");
        }
        if (request.getLocket().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Locket is required");
        }
        if (request.getDate() == null || request.getDate().toString().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Date is required");
        }
        return true;
    }

}
