package src;

public class Payment {
    private Customer cusName;
    private Order orderTime;
    private String paymentType;

    public Payment(Customer cusName, Order orderTime, String paymentType){
        this.cusName =cusName;
        this.orderTime=orderTime;
        this.paymentType = paymentType;
    }

    public Customer getCusName(){
        return cusName;
    }

    public void setCusName(Customer cusName){
        this.cusName = cusName;
    }

    public Order getOrderTime(){
        return orderTime;
    }

    public void setOrderTime(Order orderTime){
        this.orderTime = orderTime;
    }

    public String getPaymentType(){
        return paymentType;
    }

    public void setPaymentType(String paymentType){
        this.paymentType = paymentType;
    }
}
