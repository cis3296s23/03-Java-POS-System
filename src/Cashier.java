package src;

public class Cashier extends Account{
    private int cashierID;
    private String cashierName;


    public Cashier(){

    }

    public Cashier(int cashierID, String cashierName){
        this.cashierID = cashierID;
        this.cashierName = cashierName;
    }

    public int getCashierID(){
    return cashierID;
    }
}