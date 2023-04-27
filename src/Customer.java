package src;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int order_id;
    private String order_name;
    private double order_total;
    private String payment_type;
    private String card_ending;
    private Time time_ordered;

    public Customer(int order_id, String order_name,
                 double order_total, String payment_type, String card_ending, Time time_ordered) {
        this.order_id = order_id;
        this.order_name = order_name;
        this.order_total = order_total;
        this.payment_type = payment_type;
        this.card_ending = card_ending;
        this.time_ordered = time_ordered;
    }

    public Customer(int orderId, String customerName, double orderTotal, String position) {
    }

    public int getOrder_id() {
        return order_id;
    }
    public String getOrder_name(){return order_name;}
    public double getOrder_total(){return order_total;}
    public String getPayment_type(){return payment_type;}
    public String getCard_ending(){return card_ending;}
    public Time getTime_ordered(){return time_ordered;}
}
