package src;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * holds the data of the customer
 */
public class Customer {
    private int order_id;
    private String order_name;
    private double order_total;
    private String payment_type;
    private String card_ending;
    private Time time_ordered;

    /**
     * constructor for customer
     * @param order_id holds the order ID of the customer's order
     * @param order_name holds the name of the customer
     * @param order_total holds the total amount owed from the customer's order
     * @param payment_type holds the type of payment from the customer
     * @param card_ending holds the last 4 digits of the customer's card
     * @param time_ordered holds the time when the customer finished their order
     */
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

    /**
     * gets order_id
     * @return order_id
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * gets order_name
     * @return order_name
     */
    public String getOrder_name(){return order_name;}

    /**
     * gets order_total
     * @return order_total
     */
    public double getOrder_total(){return order_total;}

    /**
     * gets payment_type
     * @return payment_type
     */
    public String getPayment_type(){return payment_type;}

    /**
     * gets card_ending
     * @return card_ending
     */
    public String getCard_ending(){return card_ending;}

    /**
     * gets time_ordered
     * @return time_orderedd
     */
    public Time getTime_ordered(){return time_ordered;}
}
