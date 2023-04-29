package src;

/**
 * holds data of the manager
 */
public class Manager {
    private int managerID; // manager ID
    private String managerName; // name of the manager

    /**
     * constructor for Manager
     */
    public Manager() {

    }

    /**
     * constructor for manager
     * @param managerID integer which represents the manager's ID
     * @param managerName string which represents the manager's name
     */
    public Manager(int managerID, String managerName) {
        this.managerID = managerID;
        this.managerName = managerName;
    }

    /** @deprecated
     * updates the items in the menu
     */
    public void updateItems() {

    }

    /** @deprecated
     * adds an item to the menu
     */
    public void addItem() {

    }

    /** @deprecated
     * deletes an item from the menu
     */
    public void deleteItem() {

    }
}