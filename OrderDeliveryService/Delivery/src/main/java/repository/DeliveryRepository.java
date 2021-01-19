package repository;

import entity.Delivery;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DeliveryRepository {
    private Integer nextId=0;
    private Map<Integer, Delivery> deliveryMap=new HashMap<>();
    public Delivery getDelivery(Integer id){
        return deliveryMap.get(id);
    }
    public Delivery addDelivery(Delivery delivery){
        deliveryMap.put(delivery.getId(),delivery);
        return delivery;
    }
    public Integer getNextId(){
        return nextId++;
    }
}
