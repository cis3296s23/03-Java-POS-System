package src;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.sql.*;
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
            throw new RuntimeException(e);
        }
    }

    public void checkout() {

        List<Item> itemList = order.getItems();
        checkoutError.setText("");
        if (itemList.isEmpty()) {

            checkoutError.setText("There are currently no items in this order.");
        } else {
            // temporarily only goes to the login page
            Scene menuPage = grid.getScene();
            Window menuPageWindow = menuPage.getWindow();
            Stage primaryStage = (Stage) menuPageWindow;
            LoginPage loginPage = new LoginPage();
            Scene nextStage = loginPage.firstLogin(primaryStage);
            primaryStage.setScene(nextStage);
            primaryStage.show();
        }
    }

    public void back() {

        grid.getChildren().clear();
        orderGrid.getChildren().clear();
        Scene menuPage = grid.getScene();
        Window menuPageWindow = menuPage.getWindow();
        Stage primaryStage = (Stage) menuPageWindow;
        LoginPage loginPage = new LoginPage();

        Scene nextStage = loginPage.firstLogin(primaryStage);
        primaryStage.setScene(nextStage);
        primaryStage.show();

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
}
