package controller;

import entity.Delivery;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;
    @PostMapping
    private Order process(@RequestBody Order order){
        return deliveryService.handleOrder(order);
    }
}
