package src;

/**
 * holds information related to a cashier employee
 */
public class Cashier extends Account{
    private int cashierID;
    private String cashierName;

    /**
     * constructor for cashier
     */
    public Cashier(){

    }

    /**
     * constructor for cashier
     * @param cashierID int that represents the ID of the cashier
     * @param cashierName String that represents the name of the cashier
     */
    public Cashier(int cashierID, String cashierName){
        this.cashierID = cashierID;
        this.cashierName = cashierName;
    }

    /**
     * returns the cashierID property
     * @return cashierID
     */
    public int getCashierID(){
    return cashierID;
    }
}