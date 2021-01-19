package service;

import entity.Delivery;
import entity.Order;

public interface DeliveryService {
    void save(Delivery delivery);
    Order handleOrder(Order order);
}
