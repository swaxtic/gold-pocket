package com.simantri.simantribe.service.queue;

import com.simantri.simantribe.model.entity.Queue;
import com.simantri.simantribe.model.request.CreateQueueRequest;
import com.simantri.simantribe.repository.QueueRepository;
import com.simantri.simantribe.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateQueueService {

    @Autowired
    private ValidateQueueService validateQueueService;

    @Autowired
    private QueueRepository queueRepository;

    public void execute(CreateQueueRequest request) {
        if (validateQueueService.execute(request)) {
            Queue newQueue = new Queue();
            BeanUtils.copyProperties(request, newQueue);
            newQueue.setStatus(Constants.QUEUE_STATUS.AWAITING.getValue());
            Integer currQueue = queueRepository.countByLocket(Constants.QUEUE_STATUS.AWAITING.getValue(),
                    request.getLocket(), request.getDate());
            newQueue.setQueueNo(currQueue + 1);
            log.info("Queue = {} is successfully added.", newQueue);
            queueRepository.save(newQueue);
        }
    }
}
