package src;

public class Customer {
    private int cusNumber;

    private String cusName;


    public Customer(){

    }

    public Customer(int cusNumber, String cusName){
        this.cusNumber = cusNumber;
        this.cusName = cusName;
    }

    public int getCusNumber(){
    return cusNumber;
    }

    public String getCusName(){
    return cusName;
    }

}