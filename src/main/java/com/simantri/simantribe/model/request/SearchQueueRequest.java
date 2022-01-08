package com.simantri.simantribe.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchQueueRequest {

    private Integer start;
    private Integer limit;
    private String sortBy;
    private String sort;
    private String locket;
    private String status;
    @DateTimeFormat(iso =DateTimeFormat.ISO.DATE)
    private Date date;

}
