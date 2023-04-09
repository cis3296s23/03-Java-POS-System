package src;

public class Menu {
    private Item itemID;
    private Item itemName;
    private String itemDetail;
    private String itemType;


    public Menu() {

    }

    public Menu(Item itemID, Item itemName, String itemDetail, String itemType) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemDetail = itemDetail;
        this.itemType = itemType;
    }

    public Item getItemID() {
        return itemID;
    }

    public Item getItemName() {
        return itemName;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public String getItemType() {
        return getItemType();
    }
}