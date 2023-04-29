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

    /**
     * returns the orderID property
     * @return orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * sets the orderID property to the parameter
     * @param orderID integer that contains the ID of an order
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * returns the customerName property
     * @return customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * sets the customerName property to the parameter
     * @param customerName a string containing the name of the customer
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * returns the items parameter
     * @return items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * sets the items property to the parameter
     * @param items a list of Item objects in List format
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * returns the paymentMethod property
     * @return paymentMethod
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * sets the paymentMethod property to the parameter
     * @param paymentMethod a String that holds the name of the payment method
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * returns the orderTime property
     * @return orderTime
     */
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    /**
     * sets the orderTime property to the parameter
     * @param orderTime the time of the order in LocalDateTime format
     */
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
     * @param item Item object containing the item to add
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
     * @param item uses a string containing the item's name
     */
    // currently not functional, can be fixed by iterating through items and verifying the itemName field
    public void removeItem(String item) {
        if (items.contains(item))
            this.items.remove(item);
    }

    /**
     * clears the items from the item list parameter
     */
    public void clearItems() {
        this.items.clear();
    }

    /**
     * returns the contents of the order in a string
     * @return String with the format (without brackets): Order{customerName=[customerName]\, items=[items.toString()], orderTime=[orderTime], totalPrice=[totalPrice], paymentMethod=[paymentMethod]\}
     */
    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", items=" + items.toString() +
                ", orderTime=" + orderTime +
                ", totalPrice=" + totalPrice +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    /**
     * returns the orderID parameter
     * @return orderID
     */
    public int getOrder_id() {
        return orderID;
    }

    /**
     * returns the customerName parameter
     * @return customerName
     */
    public String getOrder_name(){return customerName;}

}

