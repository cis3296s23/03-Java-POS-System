package src;

public class Menu {
    private int itemID;
    private String itemName;
    private String category;
    private double price;


    public Menu() {

    }

    public Menu(int itemID, String itemName, String category, double price) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.category = category;
        this.price = price;
    }

    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
