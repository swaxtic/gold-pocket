package com.simantri.simantribe.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "queue")
public class Queue {
    @Id
    @SequenceGenerator(name = "queue_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "queue_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "queue_no")
    private Integer queueNo;

    @Column(name = "locket")
    private String locket;

    @Column(name = "requester_type")
    private String requesterType;

    @Column(name = "requester_name")
    private String requesterName;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "date")
    private Date date;
}
