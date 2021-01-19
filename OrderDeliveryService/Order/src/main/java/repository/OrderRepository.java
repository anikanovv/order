package repository;

import entity.Order;
import org.hibernate.event.spi.SaveOrUpdateEventListener;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class OrderRepository {
    private Map<Integer,Order> orderMap=new HashMap<>();
    @PostConstruct
    private void init(){

    }
    public Order getOrder(Integer id){
        return orderMap.get(id);
    }
    public List<Order> getOrders(){
        return new ArrayList<>(orderMap.values());
    }
    public Order addOrder(Order order){
        orderMap.put(order.getId(),order);
        return order;
    }
}
