package com.example.dockertest1.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Order {
    private String uuid;
    private int pid;
    private BigDecimal totalAmt;
    private String status;
    private String type;
    private int quantity;
    private int cc;
    private String notiType;
    private String address1;
    private String address2;
    private int postcode;
    private String state;
}
