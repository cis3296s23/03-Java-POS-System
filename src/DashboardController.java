package src;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
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
    public void adminAccess_btn() throws IOException {
        Main main = new Main();
        main.changeScene("LoginPage.fxml", "Dave's Burger");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
