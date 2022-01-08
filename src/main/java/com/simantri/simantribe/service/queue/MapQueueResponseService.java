package com.simantri.simantribe.service.queue;

import com.simantri.simantribe.model.entity.Queue;
import com.simantri.simantribe.model.response.QueueResponse;
import com.simantri.simantribe.repository.QueueRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapQueueResponseService {

    @Autowired
    private QueueRepository queueRepository;

    public QueueResponse execute(Queue queue) {
        QueueResponse queueResponse = new QueueResponse();
        BeanUtils.copyProperties(queue, queueResponse);
        return queueResponse;
    }

}
