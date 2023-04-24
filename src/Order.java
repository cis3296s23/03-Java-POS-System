package src;

import java.time.LocalDateTime;
import java.util.*;

public class Order {
    private String customerName;
    private List<Item> items = new ArrayList<>();
    private LocalDateTime orderTime;
    private double totalPrice;
    private String paymentMethod;

    public Order() {

    }
    public Order(String customerName, List<Item> items, double totalPrice, String paymentMethod) {
        this.customerName = customerName;
        this.items = items;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.orderTime = LocalDateTime.now();
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public double getTotalPrice() {

        ListIterator<Item> itemList = items.listIterator();
        totalPrice = 0;
        while (itemList.hasNext()) {
            Item currItem = itemList.next();
            totalPrice = totalPrice + currItem.getItemPrice();
        }

        return totalPrice;
    }



    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }



    public void addItem(Item item) {

        this.items.add(item);
    }

    public void removeItem(String item) {
        this.items.remove(item);
    }

    public void clearItems() {
        this.items.clear();
    }


    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", items=" + items +
                ", orderTime=" + orderTime +
                ", totalPrice=" + totalPrice +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
