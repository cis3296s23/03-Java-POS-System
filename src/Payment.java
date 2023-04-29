package src;

/**
 * holds information regarding payments
 */
public class Payment {
    private Customer cusName;
    private Order orderTime;
    private String paymentType;

    /**
     * constructor for payment
     * @param cusName the paying customer in Customer class format
     * @param orderTime the order in Order class format
     * @param paymentType type of payment
     */
    public Payment(Customer cusName, Order orderTime, String paymentType){
        this.cusName =cusName;
        this.orderTime=orderTime;
        this.paymentType = paymentType;
    }

    /**
     * returns the value of the cusName property
     * @return cusName
     */
    public Customer getCusName(){
        return cusName;
    }

    /**
     * sets the cusName property to the parameter
     * @param cusName Customer object that primarily holds the customer's name
     */
    public void setCusName(Customer cusName){
        this.cusName = cusName;
    }

    /**
     * returns the orderTime property
     * @return orderTime
     */
    public Order getOrderTime(){
        return orderTime;
    }

    /**
     * sets the orderTime property to the parameter
     * @param orderTime Order object that primarily holds the time of an order
     */
    public void setOrderTime(Order orderTime){
        this.orderTime = orderTime;
    }

    /**
     * returns the paymentType property
     * @return paymentType
     */
    public String getPaymentType(){
        return paymentType;
    }

    /**
     * sets the paymentType property to the parameter
     * @param paymentType String that represents the type of payment
     */
    public void setPaymentType(String paymentType){
        this.paymentType = paymentType;
    }
}
