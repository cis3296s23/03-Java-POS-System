package src;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

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

    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;
    private boolean clockedIn;
    public void adminAccess_btn() throws IOException {
        Main main = new Main();
        main.changeScene("LoginPage.fxml", "Dave's Burger");
    }

    public void clockIn_btn() {
        clockInTime = LocalDateTime.now();
        clockedIn = true;
        alert("Clock in time");
    }


    public void clockOut_btn() {
        clockOutTime = LocalDateTime.now();
        clockedIn = false;
        alert("Clock out time");
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
