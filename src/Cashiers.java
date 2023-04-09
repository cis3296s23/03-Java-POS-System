package src;

public class Cashiers extends Account{
    private int cashierID;
    private String cashierName;
}

    public Cashiers(){

    }

    public Cashiers(int cashierID, String cashierName){
        this.cashierID = cashierID;
        this.cashierName = cashierName;
    }

    public int getCashierID(){
    return cashierID;
    }
