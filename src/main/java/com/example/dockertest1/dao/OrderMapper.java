package com.example.dockertest1.dao;

import java.math.BigDecimal;

import com.example.dockertest1.dto.Order;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper {
    int insertNewOrder(Order order);
    String getStatus();
    int changeStatus(String orderNo, String status);
    String getNotiType(String orderNo);
    BigDecimal getAmount(String orderNo);
}
