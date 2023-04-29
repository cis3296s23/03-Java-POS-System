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

    /**
     * returns the itemID property
     * @return itemID
     */
    public int getItemID(){
    return itemID;
}

    /**
     * sets the itemID property to the parameter
     * @param itemID integer containing the ID of the item
     */
    public void setItemID(int itemID){
    this.itemID = itemID;
}

    /**
     * returns the itemName property
     * @return itemName
     */
    public String getItemName(){
    return itemName;
}

    /**
     * sets the itemName property to the parameter
     * @param itemName string containing the name of the item
     */
    public void setItemName(String itemName){
    this.itemName = itemName;
}

    /**
     * returns the itemPrice property
     * @return itemPrice
     */
    public double getItemPrice(){
    return itemPrice;
}

    /**
     * sets the itemPrice property to the parameter
     * @param itemPrice double containing the price of the item
     */
    public void setItemPrice(double itemPrice){
    this.itemPrice = itemPrice;
}

    /**
     * returns the itemQty property
     * @return itemQty
     */
    public int getItemQty(){
    return itemQty;
}

    /**
     * sets the itemQty property to the parameter
     * @param itemQty integer containing the number of the items with the context of items in an order
     */
    public void setItemQty(int itemQty){
    this.itemQty = itemQty;
}

    /**
     * returns the category property
     * @return category
     */
    public String getCategory(){
    return category;
}

    /**
     * sets the amount property to the parameter
     * @param amount double
     */
    public void setAmount(double amount){
    this.amount = amount;
}

}