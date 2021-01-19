package service;

import entity.Order;
import entity.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import repository.OrderRepository;

import java.util.List;
import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    private String deliveryServiceUrl = "";

    @Override
    public Order createOrder(Order order) {
        order.setStatus(OrderStatus.RECEIVED);
        repository.addOrder(order);
        Order deliveryResponse = null;
        try {
            deliveryResponse = restTemplate.postForObject(
                    deliveryServiceUrl, order, Order.class);
        } catch (Exception ex) {
            Objects.requireNonNull(deliveryResponse).setStatus(OrderStatus.CANCELLED);
        }
        return repository.addOrder(order);
    }

    @Override
    public List<Order> getOrders() {
        return repository.getOrders();
    }
}
