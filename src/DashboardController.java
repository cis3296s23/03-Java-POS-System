package src;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {


    @FXML
    private Button adminAccess_btn;


    @FXML
    private Button clockInOut_btn;

    @FXML
    private Button clockIn_btn;

    @FXML
    private AnchorPane clockIn_scene;

    @FXML
    private Button clockOut_btn;

    @FXML
    private TableColumn<Order, String> cusName_col;

    @FXML
    private Button menu_btn;

    @FXML
    private TableColumn<Order, Integer> orderId_col;

    @FXML
    private TableColumn<Order, String> payment_col;

    @FXML
    private TableColumn<Order, Time> timeOrdered_col;

    @FXML
    private TableColumn<Order, Double> total_col;

    @FXML
    private TableColumn<Order, String> card_ending;

    @FXML
    private Button transaction_btn;

    @FXML
    private AnchorPane transaction_scene;
    @FXML
    private TableView<Order> transaction_table;
    @FXML
    private TableColumn<OrderedItems, String> itemOrdered_col;
    @FXML
    private TableColumn<OrderedItems, Double> price_col;

    @FXML
    private TableColumn<OrderedItems, Integer> quantity_col;
    @FXML
    private TableView<OrderedItems> orderItem_table;
    @FXML
    private Label orderDetailsLabel;
    @FXML
    private Label total_label;
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Alert alert;

    private ObservableList<OrderedItems> orderedItemList;
    // show all ordered items for a given order id
    public void orderedItemShowData(int orderId) {
        orderedItemList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM ordereditems WHERE order_id = ?";

        connect = Database.connectToDB();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, orderId);
            result = prepare.executeQuery();

            OrderedItems orderedItem;
            while (result.next()) {
                orderedItem = new OrderedItems(result.getInt("item_id"),
                        result.getInt("order_id"),
                        result.getString("item_name"),
                        result.getDouble("item_price"),
                        result.getInt("item_quantity"));

                orderedItemList.add(orderedItem);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //calculate the total price of each items and its quantities
        double totalPrice = 0;

        for (OrderedItems item : orderedItemList) {
            totalPrice += item.getItem_price() * item.getItem_quantity();
        }
        Order selectedOrder = orderList.stream().filter(order -> order.getOrder_id() == orderId).findFirst().orElse(null);
        String customerName = selectedOrder != null ? selectedOrder.getOrder_name() : "";
        //store the result in another tableview and show detail of the transaction when mouse is clicked
        orderDetailsLabel.setText(String.format("Order Details for %s: ", customerName));
        // Display the total price in a label or any other appropriate UI element
        total_label.setText(String.format("%.2f $", totalPrice));
        itemOrdered_col.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        price_col.setCellValueFactory(new PropertyValueFactory<>("item_price"));
        quantity_col.setCellValueFactory(new PropertyValueFactory<>("item_quantity"));

        orderItem_table.setItems(orderedItemList);
    }
    public ObservableList<Order> orderDataList() {

        ObservableList<Order> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM orders";
        //WHERE DATE(order_date) = CURDATE()
        connect = Database.connectToDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            Order orderData;

            while (result.next()) {

                orderData = new Order(result.getInt("order_id"),
                        result.getString("customer_name"),
                        result.getDouble("order_total"),
                        result.getString("payment_type"),
                        result.getString("card_ending"),
                        result.getTime("time_ordered"));

                listData.add(orderData);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    private ObservableList<Order> orderList;
    //show all of the order data on the table
    public void orderShowData() {
        orderList = orderDataList();

        orderId_col.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        cusName_col.setCellValueFactory(new PropertyValueFactory<>("order_name"));
        total_col.setCellValueFactory(new PropertyValueFactory<>("order_total"));
        payment_col.setCellValueFactory(new PropertyValueFactory<>("payment_type"));
        card_ending.setCellValueFactory(new PropertyValueFactory<>("card_ending"));
        timeOrdered_col.setCellValueFactory(new PropertyValueFactory<>("time_ordered"));

        transaction_table.setItems(orderList);
        // Add a selection listener to the transaction_table
        transaction_table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Show ordered items for the selected order
                int orderId = newSelection.getOrder_id();
                orderedItemShowData(orderId);
            }

    });
    }
    //go to admin page when button is clicked
    public void adminAccess_btn() throws IOException {
        Main main = new Main();
        main.changeScene("LoginPage.fxml", "Dave's Burger");
    }
    //switch to any anchorpane accordingly
    public void switchForm(ActionEvent event) {

        if (event.getSource() == menu_btn) {
            transaction_scene.setVisible(false);
            clockIn_scene.setVisible(false);

        } else if (event.getSource() == transaction_btn) {
            transaction_scene.setVisible(true);
            clockIn_scene.setVisible(false);
            orderShowData();

        } else  if (event.getSource() == clockInOut_btn) {
            transaction_scene.setVisible(false);
            clockIn_scene.setVisible(true);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            orderShowData();
    }
}
