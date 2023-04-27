package src;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int order_id;
    private double order_total;
    private String payment_type;
    private String card_ending;
    private Time time_ordered;
    private String customerName;
    private List<String> items = new ArrayList<>();
    private LocalDateTime orderTime;
    private double totalPrice;
    private String paymentMethod;
    private String order_name;

    public Order(String customerName, List<String> items, double totalPrice, String paymentMethod) {
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

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }


    public Order(int order_id, String order_name,
                 double order_total, String payment_type, String card_ending, Time time_ordered) {
        this.order_id = order_id;
        this.order_name = order_name;
        this.order_total = order_total;
        this.payment_type = payment_type;
        this.card_ending = card_ending;
        this.time_ordered = time_ordered;
    }

    public Order(int orderId, String customerName, double orderTotal, String position) {
    }

    public int getOrder_id() {
        return order_id;
    }
    public String getOrder_name(){return order_name;}
    public double getOrder_total(){return order_total;}
    public String getPayment_type(){return payment_type;}
    public String card_ending(){return card_ending;}
    public Time getTime_ordered(){return time_ordered;}
}

