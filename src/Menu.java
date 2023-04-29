package src;

/**
 * holds the data of the menu from the database
 */
public class Menu {
    private int itemID;
    private String itemName;
    private String category;
    private double price;


    public Menu() {

    }

    /**
     * constructor for Menu
     * @param itemID ID of the menu item
     * @param itemName name of the menu item
     * @param category category of the menu item
     * @param price price of the menu item
     */
    public Menu(int itemID, String itemName, String category, double price) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.category = category;
        this.price = price;
    }

    /**
     * returns the itemID property
     * @return itemID
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * returns the itemName property
     * @return itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * returns the category property
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * returns the price property
     * @return price
     */
    public double getPrice() {
        return price;
    }
}
