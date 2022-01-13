package com.example.dockertest1.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeoutException;

import com.example.dockertest1.dto.Order;
import com.example.dockertest1.utils.RespResult;

public interface OrderService {
    RespResult insertNewOrder(Order order) throws IOException, TimeoutException;
    void changeStatus(Order order);
    String getNotiType(String orderNo);
    BigDecimal getAmount(String orderNo);
}
