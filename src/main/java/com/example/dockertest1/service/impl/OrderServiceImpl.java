package com.example.dockertest1.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import com.alibaba.fastjson.JSON;
import com.example.dockertest1.dao.OrderMapper;
import com.example.dockertest1.dto.Order;
import com.example.dockertest1.service.OrderService;
import com.example.dockertest1.utils.RespResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RespResult insertNewOrder(Order order) throws IOException, TimeoutException  {
        RespResult respResult;
        order.setStatus("New");
        System.out.println("order received: " + JSON.toJSONString(order));
        int i = orderMapper.insertNewOrder(order);
        System.out.println("i: " + i);
        respResult = new RespResult(200, "Inserted", null);
        return respResult;
    }

    @Override
    public void changeStatus(Order order) {
        orderMapper.changeStatus(order.getUuid(), order.getStatus());
    }

    @Override
    public String getNotiType(String orderNo) {
        return orderMapper.getNotiType(orderNo);
    }

    @Override
    public BigDecimal getAmount(String orderNo) {
        return orderMapper.getAmount(orderNo);
    }
    
}
