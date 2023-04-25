package src;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class MenuPageController implements Initializable {

    @FXML
    private GridPane grid;

    @FXML
    private GridPane orderGrid;
    @FXML
    private Label checkoutError;

    @FXML
    private Button checkout;
    @FXML
    private Button backButton;

    private Order order = new Order();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        checkoutError.setText("");
        String getMenu = "SELECT item_id, item_name, item_price, category FROM menu ORDER BY category";
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306" + "/data", "root", "root1234");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(getMenu);
            int offset = 1;
            String lastCat = "";
            HashMap<String, Item> addButtonsToItems = new HashMap<>();


            while (rs.next()) {
                String cat = rs.getString("category");
                if (!lastCat.equals(cat) || offset == 1) {

                    Label category = new Label(cat);
                    grid.add(category, 0, offset);
                    offset++;
                }
                lastCat = cat;

                Item item = new Item();
                item.setItemID(rs.getInt("item_id"));
                item.setItemName(rs.getString("item_name"));
                item.setItemPrice(rs.getDouble("item_price"));

                Label itemID = new Label("(" + item.getItemID() + ") ");
                Label name = new Label(item.getItemName());
                Label item_price = new Label(String.format("%.2f", item.getItemPrice()) + " ");
                Button addItem = new Button("Add");
                addItem.setId(String.valueOf(offset));
                grid.add(itemID, 1, offset);
                grid.add(name, 2, offset);
                grid.add(item_price, 3, offset);
                grid.add(addItem, 4, offset);

                addButtonsToItems.put(addItem.getId(), item);
                offset++;

                addItem.setOnAction(addEvent -> {

                    clearPage();

                    Item selection = addButtonsToItems.get(addItem.getId());

                    order.addItem(selection);

                    refreshOrderList();

                });



            }
        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println(e + "\nUnable to access the menu.");
        }
    }

    public void checkout() throws IOException {

        List<Item> itemList = order.getItems();
        checkoutError.setText("");
        if (itemList.isEmpty()) {

            checkoutError.setText("There are currently no items in this order.");
        } else {
            writeOrder();
            Main main = new Main();
            main.changeScene("PayMethod.fxml", "Dave's Burger");
        }
    }

    public void back() throws IOException {

        clearPage();
        Main main = new Main();
        main.changeScene("DashPage.fxml", "Dave's Burger");

    }

    public void refreshOrderList() {

        HashMap<String, Integer> removeButtonsToItems = new HashMap<>();
        ListIterator<Item> orderedItems = order.getItems().listIterator();

        clearPage();
        int index = 1;
        while (orderedItems.hasNext()) {
            Item currItem = orderedItems.next();

            Label oItemName = new Label(currItem.getItemName());
            Label oItemPrice = new Label(String.format("%.2f", currItem.getItemPrice()) + " ");

            Button removeItem = new Button("-");
            removeItem.setId(String.valueOf(index));
            removeButtonsToItems.put(removeItem.getId(), index-1);

            removeItem.setOnAction(removeEvent -> {
                checkoutError.setText("");
                int target = removeButtonsToItems.get(removeItem.getId());
                order.getItems().remove(target);
                refreshOrderList();
            });

            orderGrid.add(oItemName, 0, index);
            orderGrid.add(oItemPrice, 1, index);
            orderGrid.add(removeItem, 2, index);

            index++;

        }
        Label totalText = new Label("Total: ");
        Label oTotal = new Label(String.format("%.2f", order.getTotalPrice()));
        orderGrid.add(totalText, 1, index);
        orderGrid.add(oTotal, 2, index);
    }

    public void clearPage() {

        checkoutError.setText("");
        orderGrid.getChildren().clear();
    }

    public void writeOrder() {
        String makeOrderTable = "CREATE TABLE orders (" +
                                "orderID int AUTO_INCREMENT," +
                                "orderTime varchar(100)," +
                                "customerName varchar(200)," +
                                "paymentMethod varchar(20)," +
                                "PRIMARY KEY (orderID));";
        String makeItemTable = "CREATE TABLE orderedItems (" +
                                "orderID int NOT NULL," +
                                "itemID int NOT NULL," +
                                "FOREIGN KEY (orderID) REFERENCES orders (orderID)," +
                                "FOREIGN KEY (itemID) REFERENCES menu (item_id));";
        LocalDateTime curr = LocalDateTime.now();
        String timeString = curr.toString();
        String writeOrder = "INSERT INTO orders (orderTime) VALUES ('" + timeString + "');";

        List <Item> orderItems = order.getItems();

        ListIterator<Item> iterator = orderItems.listIterator();

        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306" + "/data", "root", "root1234");
            Statement st, st2, st3, st4;
            st = conn.createStatement();
            st.executeUpdate(makeOrderTable);
            st2 = conn.createStatement();
            st2.executeUpdate(makeItemTable);
            st3 = conn.createStatement();
            st3.executeUpdate(writeOrder);
            st4 = conn.createStatement();

            ResultSet rs = st4.executeQuery("SELECT orderID FROM orders WHERE orderTime='" + timeString + "';");
            rs.next();
            order.setOrderID(rs.getInt("orderID"));
            while (iterator.hasNext()) {
                Item item = iterator.next();
                String writeItem = "INSERT INTO orderedItems (orderID, itemID) VALUES ("
                        + order.getOrderID() + ", " + item.getItemID() + ");";
                st.executeUpdate(writeItem);
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }
}