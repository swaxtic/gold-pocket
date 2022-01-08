package com.simantri.simantribe.service.queue;

import com.simantri.simantribe.model.response.QueueResponse;
import com.simantri.simantribe.repository.QueueRepository;
import com.simantri.simantribe.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetQueueByIdService {

    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private MapQueueResponseService mapQueueResponseService;

    public QueueResponse execute(Long id) {
        return queueRepository.findById(id).map(data -> mapQueueResponseService.execute(data))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.ERR_MSG_NOTFOUND);
                });
    }
}
