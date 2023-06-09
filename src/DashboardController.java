package src;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * controller for DashPage.fxml
 */
public class DashboardController implements Initializable {

    String[][] employees = {{"1111", "John Smith", "john@temple.edu", "16.00", "Cashier"},
            {"1112", "Jane Doe", "jane@temple.edu", "16.00", "Cashier"},
            {"1113", "Kyle Walker", "kyle@temple.edu", "20.00", "Chef"},
            {"1114", "Jack Grealish", "jack@temple.edu", "25.00", "HeadChef"}};


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
    private PasswordField employeeNumberField;

    @FXML
    private TableColumn<Customer, String> cusName_col;

    @FXML
    private Button menu_btn;

    @FXML
    private TableColumn<Customer, Integer> orderId_col;

    @FXML
    private TableColumn<Customer, String> payment_col;

    @FXML
    private TableColumn<Customer, Time> timeOrdered_col;

    @FXML
    private TableColumn<Customer, Double> total_col;

    @FXML
    private TableColumn<Customer, String> card_ending;

    @FXML
    private Button transaction_btn;

    @FXML
    private AnchorPane transaction_form;

    private Alert alert;

    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;
    private boolean clockedIn;
    @FXML
    private AnchorPane transaction_scene;
    @FXML
    private TableView<Customer> transaction_table;
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

    private static final String TIMECARD_FILE = "src/Timecard.txt";


    private ObservableList<OrderedItems> orderedItemList; // holds a list items in an order for the table in
                                                          // the GUI to reference

    /**
     * shows all ordered items for a given order id
     * @param orderId ID of the order
     */
    public void orderedItemShowData(int orderId) {
        orderedItemList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM ordereditems WHERE order_id = ?";

        connect = Database.connectToDB(false);

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
        Customer selectedOrder = orderList.stream().filter(order -> order.getOrder_id() == orderId).findFirst().orElse(null);
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

    /**
     * returns an observable list of orders taken from the orders database
     * @return an observable list of orders for a table
     */
    public ObservableList<Customer> orderDataList() {

        ObservableList<Customer> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM orders";
        //WHERE DATE(order_date) = CURDATE()
        connect = Database.connectToDB(false);

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            Customer orderData;

            while (result.next()) {

                orderData = new Customer(result.getInt("order_id"),
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
    private ObservableList<Customer> orderList;

    /**
     * shows all order data on the table
     */
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

    /**
     * goes to the admin page when the adminAccess button button is clicked
     * @throws IOException if the given page's fxml file cannot be found, an exception is thrown
     */
    public void adminAccess_btn() throws IOException {
        Main main = new Main();
        main.changeScene("LoginPage.fxml", "Dave's Burger");
    }

    /**
     * clocks in an employee with a given empNum from the employeeNumberField text field
     */
    public void clockIn_btn() {
        String employeeNumber = employeeNumberField.getText();
        boolean foundEmployee = false;
        String employeeName = "";
        for (String[] employee : employees) {
            if (employee[0].equals(employeeNumber)) {
                foundEmployee = true;
                employeeName = employee[1];
                break;
            }
        }
        if (foundEmployee) {
            clockInTime = LocalDateTime.now();
            clockedIn = true;
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Clock in time");
            alert.setHeaderText(null);
            alert.setContentText("You have clocked in at " + clockInTime + " as " + employeeName);
            alert.showAndWait();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(TIMECARD_FILE, true));
                writer.write("Clock-in: " + clockInTime + " - " + employeeName + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid employee number");
            alert.setHeaderText(null);
            alert.setContentText("The employee number you entered is invalid.");
            alert.showAndWait();
        }
    }


    /**
     * clocks out the employee after having clocked in when pressing the clock out button
     */
    public void clockOut_btn() {
        String employeeNumber = employeeNumberField.getText();
        boolean foundEmployee = false;
        String employeeName = "";
        for (String[] employee : employees) {
            if (employee[0].equals(employeeNumber)) {
                foundEmployee = true;
                employeeName = employee[1];
                break;
            }
        }
        if (foundEmployee) {
            clockOutTime = LocalDateTime.now();
            clockedIn = false;
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Clock out time");
            alert.setHeaderText(null);
            alert.setContentText(employeeName + ", you have clocked out at " + String.valueOf(clockOutTime));
            alert.showAndWait();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(TIMECARD_FILE, true));
                writer.write("Clock-out: " + clockOutTime + " - " + employeeName + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid employee number");
            alert.setHeaderText(null);
            alert.setContentText("The employee number you entered is invalid. Please try again.");
            alert.showAndWait();
        }
    }

    /**
     * returns to the menu page when the menu button is clicked
     * @throws IOException if the given page's fxml file cannot be found, an exception is thrown
     */
    public void menu_btn() throws IOException {

        Main main = new Main();
        main.changeScene("MenuPage.fxml", "Dave's Burger");
    }

    /**
     * shows date information regarding clock in/out in an alert
     * @param message message to display in the alert
     */
    public void alert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Clock In/Out");
        alert.setHeaderText(null);
        LocalDateTime now = LocalDateTime.now();
        alert.setContentText(message + " at " + now.format(DateTimeFormatter.ISO_DATE_TIME));
        alert.showAndWait();
    }


    /**
     * switches to any anchor pane with a given event
     * @param event button press
     */
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

    /**
     * when the page is initialized, this method is called
     * uses the orderShowData method
     * @param location refer to the Initializable interface from the JavaFX fxml library
     * @param resources refer to the Initializable interface from the JavaFX fxml library
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            orderShowData();
    }
}
