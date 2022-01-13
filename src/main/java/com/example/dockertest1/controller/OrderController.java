package com.example.dockertest1.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import com.alibaba.fastjson.JSON;
import com.example.dockertest1.abstractFactory.BigBike;
import com.example.dockertest1.abstractFactory.SmallBike;
import com.example.dockertest1.abstractFactory.Vehicle;
import com.example.dockertest1.adapter.ConvertToUsdImpl;
import com.example.dockertest1.adapter.ConvertToUsd;
import com.example.dockertest1.adapter.ConverterAdapter;
import com.example.dockertest1.adapter.ConverterAdapterImpl;
import com.example.dockertest1.builder.Address;
import com.example.dockertest1.dto.Order;
import com.example.dockertest1.factory.EmailNotification;
import com.example.dockertest1.factory.Notification;
import com.example.dockertest1.factory.PushNotification;
import com.example.dockertest1.factory.SMSNotification;
import com.example.dockertest1.service.OrderService;
import com.example.dockertest1.utils.RespResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/submitOrder")
    public RespResult submitOrder(@RequestBody Order order) throws IOException, TimeoutException {
        order.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
        Address address = new Address.AddressBuilder(order.getUuid(), order.getAddress1(), order.getAddress2(), order.getPostcode(), order.getState()).build();
        System.out.println("address: " + JSON.toJSONString(address));
        Vehicle car;
        switch (order.getType()) {
            case "small bike":
                car = new SmallBike();
                order.setCc(car.getCc());
                System.out.println("order received: " + JSON.toJSONString(order));
                return orderService.insertNewOrder(order);

            case "big bike":
                car = new BigBike();
                order.setCc(car.getCc());
                System.out.println("order received: " + JSON.toJSONString(order));
                return orderService.insertNewOrder(order);

            default:
                throw new RuntimeException("Invalid Order");
        }
    }

    @PostMapping("/changeStatus")
    public void changeStatus(@RequestBody Order order) throws IOException, TimeoutException {
        orderService.changeStatus(order);
        if (order.getStatus().equals("approved")) {
            order.setNotiType(orderService.getNotiType(order.getUuid()));
            Notification noti;
            switch (order.getNotiType()) {
                case "email":
                    noti = new EmailNotification();
                    noti.notifyUser();
                    break;

                case "sms":
                    noti = new SMSNotification();
                    noti.notifyUser();
                    break;

                case "push":
                    noti = new PushNotification();
                    noti.notifyUser();
                    break;
            }
        }
    }

    @PostMapping("/convertToUsd")
    public void convertToUsd(@RequestBody Order order) throws IOException, TimeoutException {
        BigDecimal amount = orderService.getAmount(order.getUuid());
        ConvertToUsd usdCurrency = new ConvertToUsdImpl(amount);
        ConverterAdapter myrToUsd = new ConverterAdapterImpl(usdCurrency);
        System.out.println("USD Currency: " + JSON.toJSONString(myrToUsd.convert()));
    }

}
