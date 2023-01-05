package com.example.backend.Service.kitchen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.backend.model.Orders.Order;

import java.util.*;

public class KitchenService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Order> getOrders() {
        String sql = "Select * FROM orders";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));

    }

    public Order createOrder(Order order) {
        String sql = "INSERT INTO orders(item,quantity) VALUES(?,?)";
        jdbcTemplate.update(sql, order.getItem(), order.getQuantity());
        return order;
    }
}
