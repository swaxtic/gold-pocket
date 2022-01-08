package com.simantri.simantribe.service.queue;

import com.simantri.simantribe.model.request.QueueStatusRequest;
import com.simantri.simantribe.repository.QueueRepository;
import com.simantri.simantribe.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UpdateProcessStatusQueueService {

    @Autowired
    private QueueRepository queueRepository;

    public boolean execute(QueueStatusRequest request) {
        this.queueRepository.findById(request.getId()).ifPresentOrElse(data -> {
            data.setStatus(request.getStatus());
            queueRepository.save(data);
        }, ()-> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.ERR_MSG_NOTFOUND);
        });
        return true;
    }
}
