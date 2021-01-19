package service;

import entity.Delivery;
import entity.Order;
import entity.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DeliveryRepository;

import java.time.LocalDate;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository repository;

    @Override
    public void save(Delivery delivery) {
        delivery.setId(repository.getNextId());
        repository.addDelivery(delivery);
    }

    @Override
    public Order handleOrder(Order order) {
        LocalDate shippingDate = null;
        shippingDate = LocalDate.now().plusDays(1);
        save(Delivery.builder()
                .deliveryDate(shippingDate)
                .customer(order.getCustomer())
                .build()
        );
        order.setDeliveryDate(shippingDate);
        order.setOrderStatus(OrderStatus.HANDEDTODELIVERY);
        return order;
    }
}
