package src;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.*;

/**
 * holds order information
 */
public class Order {
    private int orderID;
    private String customerName;
    private List<Item> items = new ArrayList<>();
    private LocalDateTime orderTime;

    private double totalPrice;
    private String paymentMethod;

    public Order() {

    }

    /**
     * constructor for Order
     * @param customerName name of the customer who made the order
     * @param items list of items in the order
     * @param totalPrice total price of the order
     * @param paymentMethod payment method for the order
     */
    public Order(String customerName, List<Item> items, double totalPrice, String paymentMethod) {
        this.customerName = customerName;
        this.items = items;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
    }

    /**
     * constructor for Order
     * @param customerName name of the customer who made the order
     * @param items list of items in the order
     * @param totalPrice total price of the order
     * @param paymentMethod payment method for the order
     * @param orderTime time of the order's completion
     */
    public Order(String customerName, List<Item> items, double totalPrice, String paymentMethod, LocalDateTime orderTime) {
        this.customerName = customerName;
        this.items = items;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.orderTime = orderTime;
    }

    /**
     * constructor for Order
     * @param orderID id of the order
     * @param customerName name of the customer who made the order
     * @param items list of items in the order
     * @param totalPrice total price of the order
     * @param paymentMethod payment method for the order
     */
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

    /**
     * gets the total price of the items in the order
     * @return totalPrice
     */
    public double getTotalPrice() {

        ListIterator<Item> itemList = items.listIterator();
        totalPrice = 0;
        while (itemList.hasNext()) {
            Item currItem = itemList.next();
            totalPrice = totalPrice + currItem.getItemPrice();
        }

        return totalPrice;
    }

    /**
     * adds an item to the item list parameter
     * @param item the item to add
     */
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

    /**
     * removes an item from the item list parameter
     * @param item
     */
    public void removeItem(String item) {
        this.items.remove(item);
    }

    /**
     * clears the items from the item list parameter
     */
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

