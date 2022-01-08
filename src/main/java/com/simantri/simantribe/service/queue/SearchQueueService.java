package com.simantri.simantribe.service.queue;

import com.simantri.simantribe.model.entity.Queue;
import com.simantri.simantribe.model.request.SpecificationRequest;
import com.simantri.simantribe.model.response.PageResponse;
import com.simantri.simantribe.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class SearchQueueService {

    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private MapQueueResponseService mapQueueResponseService;

    public PageResponse execute(SpecificationRequest request) {
        Page<Queue> queuePage = queueRepository.findAll(request.getSpecification(), request.getPageable());
        return PageResponse.builder()
                .page(queuePage.isEmpty() ? null : queuePage.map(data -> mapQueueResponseService.execute(data)))
                .build();
    }

}
