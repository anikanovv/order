package entity;

public class Product {
    Integer id;
    String name;
    Integer price;
    Integer amount;

    public Integer getFullCost(){
        return price*amount;
    }
}
