package service;

import entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    List<Order> getOrders();
}