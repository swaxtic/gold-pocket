package com.simantri.simantribe.controller;

import com.simantri.simantribe.model.request.QueueStatusRequest;
import com.simantri.simantribe.model.request.SearchQueueRequest;
import com.simantri.simantribe.model.request.SpecificationRequest;
import com.simantri.simantribe.model.response.QueueResponse;
import com.simantri.simantribe.model.response.RestResponse;
import com.simantri.simantribe.model.request.CreateQueueRequest;
import com.simantri.simantribe.service.queue.CreateQueueService;
import com.simantri.simantribe.service.queue.GetQueueByIdService;
import com.simantri.simantribe.service.queue.SearchQueueService;
import com.simantri.simantribe.service.queue.UpdateProcessStatusQueueService;
import com.simantri.simantribe.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/antrian")
@Slf4j
public class QueueController {

    @Autowired
    private CreateQueueService createQueueService;

    @Autowired
    private SearchQueueService searchQueueService;

    @Autowired
    private GetQueueByIdService getQueueByIdService;

    @Autowired
    private UpdateProcessStatusQueueService updateProcessStatusQueueService;

    @PostMapping("/create")
    public RestResponse createQueue (@RequestBody CreateQueueRequest createQueueRequest) {
        createQueueService.execute(createQueueRequest);
        return new RestResponse(null, Constants.SUCCESS_MSG_SUBMIT, true);
    }

    @GetMapping("/search")
    public ResponseEntity<RestResponse> searchQueue (@Validated SearchQueueRequest searchQueueRequest) {
        Specification specification = getSpecsQueue(searchQueueRequest);
        Page page = searchQueueService.execute(SpecificationRequest.builder()
                .specification(specification)
                .pageable(getPageable(searchQueueRequest))
                .build()).getPage();
        return getPageResponse(page);
    }

    @GetMapping("/detail/{id}")
    public RestResponse getQueueById (@PathVariable("id") Long id) {
        QueueResponse queueResponse = getQueueByIdService.execute(id);
        return new RestResponse(queueResponse, Constants.SUCCESS_MSG_DATA_FOUND, true);
    }

    @PostMapping("/process-queue/{id}")
    public RestResponse processQueue (@PathVariable("id") Long id) {
        Boolean isSubmitted = this.updateProcessStatusQueueService.execute(QueueStatusRequest.builder()
                .id(id)
                .status(Constants.QUEUE_STATUS.ON_PROCESS.getValue())
                .build());
        return new RestResponse(null, Constants.SUCCESS_MSG_SUBMIT, isSubmitted);
    }

    @PostMapping("/finish-queue/{id}")
    public RestResponse finishQueue (@PathVariable("id") Long id) {
        Boolean isSubmitted = this.updateProcessStatusQueueService.execute(QueueStatusRequest.builder()
                .id(id)
                .status(Constants.QUEUE_STATUS.FINISHED.getValue())
                .build());
        return new RestResponse(null, Constants.SUCCESS_MSG_SUBMIT, isSubmitted);
    }

    private Specification getSpecsQueue(SearchQueueRequest request) {
        return Specification.where((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (ObjectUtils.isNotEmpty(request.getLocket())) {
                predicates.add(criteriaBuilder.equal(root.get("locket"), request.getLocket()));
            }
            if (ObjectUtils.isNotEmpty(request.getStatus())) {
                predicates.add(criteriaBuilder.equal(root.get("status"), request.getStatus()));
            }
            if (ObjectUtils.isNotEmpty(request.getDate())) {
                predicates.add(criteriaBuilder.equal(root.<Date>get("date"), request.getDate()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        });
    }

    protected Pageable getPageable(SearchQueueRequest searchQueueRequest){
        int page = ObjectUtils.isNotEmpty(searchQueueRequest.getStart())? 0 : searchQueueRequest.getStart();
        int size = ObjectUtils.isNotEmpty(searchQueueRequest.getLimit()) ? Integer.MAX_VALUE : searchQueueRequest.getLimit();
        Boolean isDescending = StringUtils.isNotEmpty(searchQueueRequest.getSort()) && searchQueueRequest.getSort().equals("DESC");
        Sort.Direction sort = isDescending ? Sort.Direction.DESC :
                Sort.Direction.ASC;
        String sortBy = StringUtils.isEmpty(searchQueueRequest.getSortBy()) ? "id" : searchQueueRequest.getSortBy();
        return PageRequest.of(page, size, sort, sortBy);
    }

    private ResponseEntity<RestResponse> getPageResponse(Page dataPage){
        RestResponse response;
        if(ObjectUtils.isEmpty(dataPage)) {
            response = new RestResponse(null, Constants.ERR_MSG_NOTFOUND, false);
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
        response = new RestResponse(dataPage, Constants.SUCCESS_MSG_DATA_FOUND, true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
