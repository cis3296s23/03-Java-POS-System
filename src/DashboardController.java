package src;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
    private AnchorPane clockIn_scene;

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
    private AnchorPane transaction_scene;
    public void adminAccess_btn() throws IOException {
        Main main = new Main();
        main.changeScene("LoginPage.fxml", "Dave's Burger");
    }
    public void switchForm(ActionEvent event) {

        if (event.getSource() == menu_btn) {
            transaction_scene.setVisible(false);
            clockIn_scene.setVisible(false);

        } else if (event.getSource() == transaction_btn) {
            transaction_scene.setVisible(true);
            clockIn_scene.setVisible(false);

        } else  if (event.getSource() == clockInOut_btn) {
            transaction_scene.setVisible(false);
            clockIn_scene.setVisible(true);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
