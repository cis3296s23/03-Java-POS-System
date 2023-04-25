package src;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    String[][] employees = {{"1111", "John Smith", "john@temple.edu", "16.00", "Cashier"},
            {"1112", "Jane Doe", "jane@temple.edu", "16.00", "Cashier"},
            {"1113", "Kyle Walker", "kyle@temple.edu", "20.00", "Chef"},
            {"1114", "Jack Grealish", "jack@temple.edu", "25.00", "HeadChef"}};

    @FXML
    private Button adminAccess_btn;

    @FXML
    private TableColumn<?, ?> cardEnd_col;

    @FXML
    private Button clockInOut_btn;

    @FXML
    private Button clockIn_btn;

    @FXML
    private Button clockOut_btn;

    @FXML
    private PasswordField employeeNumberField;

    @FXML
    private TableColumn<?, ?> cusName_col;

    @FXML
    private Button menu_btn;

    @FXML
    private TableColumn<?, ?> orderId_col;

    @FXML
    private TableColumn<?, ?> orderNum_col;

    @FXML
    private TableColumn<?, ?> payment_col;

    @FXML
    private TableColumn<?, ?> timeOrdered_col;

    @FXML
    private TableColumn<?, ?> total_col;

    @FXML
    private Button transaction_btn;

    @FXML
    private AnchorPane transaction_form;

    private Alert alert;

    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;
    private boolean clockedIn;
    public void adminAccess_btn() throws IOException {
        Main main = new Main();
        main.changeScene("LoginPage.fxml", "Dave's Burger");
    }

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
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid employee number");
            alert.setHeaderText(null);
            alert.setContentText("The employee number you entered is invalid.");
            alert.showAndWait();
        }
    }



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
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid employee number");
            alert.setHeaderText(null);
            alert.setContentText("The employee number you entered is invalid. Please try again.");
            alert.showAndWait();
        }
    }


    public void menu_btn() throws IOException {

        Main main = new Main();
        main.changeScene("MenuPage.fxml", "Dave's Burger");
    }

    public void alert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Clock In/Out");
        alert.setHeaderText(null);
        LocalDateTime now = LocalDateTime.now();
        alert.setContentText(message + " at " + now.format(DateTimeFormatter.ISO_DATE_TIME));
        alert.showAndWait();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
