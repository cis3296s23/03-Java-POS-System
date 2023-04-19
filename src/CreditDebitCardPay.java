package src;

import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.table.TableColumn;

import static javafx.application.Application.launch;
//extends application for JavaFX

public class CreditDebitCardPay implements Initializable {
    @FXML
    private Label nameLabel, PayInfoLabel, mobileNumLabel, cardNumLabel, ExpDateLabel, CVVLabel, rewardsLabels;

    @FXML
    private TextField nameTextField, mobileNumTextField, cardNumTextField, ExpDateTextField, CVVTextField;

    @FXML
    private RadioButton tenPercentOffRadioBtn, fifteenPercentOffRadioBtn,twentyPercentOffRadioBtn;

    @FXML
    private Button customButton, saveButton;

    @FXML
    private TableView<Item> yourOrderTableView;

    @FXML
    private TextField subTotalTextField, discountTextField, totalTextField;

    @FXML
    private Label totalLabel, yourOrderLabel, subTotalLabel, discountLabel;

    @FXML
    private Button processPaymentButton;

    @FXML
    private Button backButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String rightPositionCSS = "-fx-alignment: CENTER-RIGHT;";
        String centerPostionCSS = "-fx-alignment: CENTER;";

        //TableColumn<Item, String>

    }
}
