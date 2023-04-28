package src;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.*;

public class Order {
    private int orderID;
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
    }

    public Order(String customerName, List<Item> items, double totalPrice, String paymentMethod, LocalDateTime orderTime) {
        this.customerName = customerName;
        this.items = items;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.orderTime = orderTime;
    }

    public Order(int orderID, String customerName, List<Item> items, double totalPrice, String paymentMethod) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.items = items;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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

    public void addItem(Item item) {
        for (Item existingItem : items) {
            if (existingItem.getItemID() == item.getItemID()) {
                existingItem.setItemQty(existingItem.getItemQty() + 1);
                return;
            }
        }
        item.setItemQty(1);
        items.add(item);
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

    public int getOrder_id() {
        return orderID;
    }
    public String getOrder_name(){return customerName;}

}

