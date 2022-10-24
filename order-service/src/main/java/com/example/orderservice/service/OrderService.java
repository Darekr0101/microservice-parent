package com.example.orderservice.service;

import com.example.orderservice.dto.OrderRequest;

public interface OrderService {
    public String placeOrder(OrderRequest orderRequest);
}
