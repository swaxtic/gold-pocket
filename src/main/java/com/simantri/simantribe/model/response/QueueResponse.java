package com.simantri.simantribe.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueueResponse {
    private Long id;
    private String status;
    private Integer queueNo;
    private String locket;
    private String requesterType;
    private String requesterName;
    private String phoneNo;
    private String email;
    private String address;
    private Date date;
}
