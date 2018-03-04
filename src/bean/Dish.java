package bean;

import java.io.Serializable;


public class Dish extends Resraurant implements Serializable {

    private int id;
    private String name;
    private int price;
    private int weight;

    public Dish(int id, String name, int price, int weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }
    public Dish(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void showInfo(Dish dish) {
        System.out.println("ID is " + id + "\n" + " Name is " + name + "\n" + " Price is " + price + "\n" + " Weight is " + weight);
    }

    @Override
    public String toString() {
        return "dishID = " + id +
                "; dishName = " + name +
                "; dishPrice = " + price +
                "; dishWeight = " + weight;
    }
}
