package src;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableColumn;

import static javafx.application.Application.launch;
//extends application for JavaFX

/**
 * controller for the CardPay page
 */
public class CardPay implements Initializable{
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
    private Stage stage;
    private Scene scene;
    private  Parent root;

    /**
     * Implemented the back button to return back to the Payment Page
     * @param event
     * @throws IOException
     */
    public void switchBackToPaymentMethod(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PayMethod.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*
    // Implemented the proceed payment button to return to the Card Reciept Page
    // Get receipt when proceed to payment
    public void getReciept(ActionEvent event) throws IOException {
        String custName = nameTextField.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CardReciept.fxml"));
        root = loader.load();

        CardReciept cardReciept = loader.getController();
        //cardReciept.displayReciept(custName);

        //root = FXMLLoader.load(getClass().getResource("PaymentMethod.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    */

    /**
     * validate card inputs when the Save button is pressed
     * @param event
     */
    public void SaveBtnAction(ActionEvent event){
        boolean cardNumValidator = DataValidator.cardNumFormat(cardNumTextField, cardNumLabel,"Format must be XXXX-XXXX-XXXX-XXXX from 0-9");
        boolean cardCVV_Validator = DataValidator.cardCVVFormat(CVVTextField, CVVLabel, "Format must be *** from 0-9");
    }

    /**
     * on launch of the page, this method is called
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
