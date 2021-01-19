package entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Delivery {
    Integer id;
    LocalDate deliveryDate;
    Customer customer;
    Order order;

    @Builder
    public Delivery(Integer id, LocalDate deliveryDate, Customer customer, Order order) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.customer = customer;
        this.order = order;
    }
}
