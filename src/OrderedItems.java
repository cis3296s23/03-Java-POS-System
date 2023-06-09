package src;

import java.sql.Time;

/**
 * information related to the items in an order
 */
public class OrderedItems {
    private int item_id;
    private int order_id;
    private String item_name;
    private double item_price;
    private int item_quantity;

    /**
     * constructor for orderedItems
     * @param item_id unique ID of the item
     * @param order_id unique ID of the order
     * @param item_name name of the item
     * @param item_price price of the item
     * @param item_quantity quantity of the item in the order
     */
    public OrderedItems(int item_id, int order_id, String item_name, double item_price, int item_quantity){
        this.item_id = item_id;
        this.order_id = order_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_quantity = item_quantity;
    }

    /**
     * returns the item_id property
     * @return item_id
     */
    public int getItem_id(){return item_id;}

    /**
     * returns the order_id property
     * @return order_id
     */
    public int getOrder_id(){return order_id;}

    /**
     * returns the item_name property
     * @return item_name
     */
    public String getItem_name(){return item_name;}

    /**
     * returns the item_price property
     * @return item_price
     */
    public double getItem_price(){return item_price;}

    /**
     * returns the item_quantity property
     * @return item_quantity
     */
    public int getItem_quantity(){return item_quantity;}

}
