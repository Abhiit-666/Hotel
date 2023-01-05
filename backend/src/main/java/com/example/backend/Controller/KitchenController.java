package com.example.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.Service.kitchen.KitchenService;
import com.example.backend.model.Orders.Order;

import java.util.*;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    private KitchenService kitchenService;

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return kitchenService.getOrders();
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return kitchenService.createOrder(order);
    }

}
