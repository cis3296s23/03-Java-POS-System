package src;

public class Item{
    private int itemID;
    private String itemName;
    private double itemPrice;
    private int itemQty;
    private double amount;


public Item(){
}

public Item(int itemID, String itemName, double itemPrice, int itemQty, double amount){
    this.itemID = itemID;
    this.itemName = itemName;
    this.itemPrice = itemPrice;
    this.itemQty = itemQty;
    this.amount = amount;
}

public int getItemID(){
    return itemID;
}

public void setItemID(int itemID){
    this.itemID = itemID;
}

public String getItemName(){
    return itemName;
}

public void setItemName(String itemName){
    this.itemName = itemName;
}

public double getItemPrice(){
    return itemPrice;
}

public void setItemPrice(double itemPrice){
    this.itemPrice = itemPrice;
}

public int getItemQty(){
    return itemQty;
}

public void setItemQty(int itemQty){
    this.itemQty = itemQty;
}

public double getAmount(){
    return amount;
}

public void setAmount(double amount){
    this.amount = amount;
}

}