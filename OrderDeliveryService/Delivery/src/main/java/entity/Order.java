package entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Order {
    Integer id;
    Customer customer;
    LocalDate deliveryDate;
    OrderStatus orderStatus;
}
