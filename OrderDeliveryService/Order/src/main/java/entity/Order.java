package entity;

import lombok.Data;

import java.util.List;
@Data
public class Order {
    Integer id;
    Customer customer;
    OrderStatus status;
    List<Product> productList;
}
