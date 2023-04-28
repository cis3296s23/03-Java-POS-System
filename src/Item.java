package src;

/**
 * holds item data
 */
public class Item{
    private int itemID;
    private String itemName;
    private double itemPrice;
    private int itemQty;

    private String category;
    private double amount;


public Item(){
}

    /**
     * constructor for Item
     * @param itemID holds the item ID
     * @param itemName holds the item's name
     * @param itemPrice holds the item's default price
     * @param itemQty holds the item quantity in an order
     * @param category holds the category of the item
     */
    public Item(int itemID, String itemName, double itemPrice, int itemQty, String category){
    this.itemID = itemID;
    this.itemName = itemName;
    this.itemPrice = itemPrice;
    this.itemQty = itemQty;
    this.category = category;
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

public String getCategory(){
    return category;
}

public void setAmount(double amount){
    this.amount = amount;
}

}