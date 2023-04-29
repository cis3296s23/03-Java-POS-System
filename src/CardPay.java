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
    private TextField nameTextField;
    @FXML
    private TextField mobileNumTextField;
    @FXML
    private TextField cardNumTextField;
    @FXML
    private TextField ExpDateTextField;
    @FXML
    private TextField CVVTextField;

    @FXML
    private RadioButton tenPercentOffRadioBtn, fifteenPercentOffRadioBtn,twentyPercentOffRadioBtn;

    @FXML
    private Button customButton, saveButton;

    @FXML
    private TableView<Item> yourOrderTableView;

    @FXML
    private Label subTotalLabel;
    @FXML
    private Label totalLabel;
    @FXML
    private Label  discountLabel;

    @FXML
    private Button processPaymentButton;

    @FXML
    private ChoiceBox<String>  YearNum;

    private String[] years = {"2023", "2024", "2025","2026", "2027", "2028", "2029","2030"};

    @FXML
    private ChoiceBox<String> MonthNum;

    private String[] months = {"01","02","03","04","05","06","07","08","09","10","11","12"};

    @FXML
    private Button backButton;
    private Stage stage;
    private Scene scene;
    private  Parent root;

    /**
     * changes the scene to the PayMethod page
     * @throws IOException if the given page's fxml file cannot be found, an exception is thrown
     */
    public void switchBackToPaymentMethod() throws IOException {
        Main main = new Main();
        main.changeScene("PayMethod.fxml", "Dave's Burger");
    }

    /**
     * changes the scene to the Receipt page
     * @param event button press
     * @throws IOException if the given page's fxml file cannot be found, an exception is thrown
     */
    public void switchToReciept(ActionEvent event) throws IOException {
       // Main main = new Main();
       // main.changeScene("CardReciept.fxml", "Dave's Burger");

        String custName = nameTextField.getText();
        String mobNum = mobileNumTextField.getText();
        //String subTotal = subTotalLabel.getText();
        //String discount = discountLabel.getText();
       // String total = totalLabel.getText();
       // String paidAmnt = totalLabel.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CardReciept.fxml"));
        root = loader.load();

        CardReciept cardReciept = loader.getController();
        cardReciept.displayCustName(custName);
        cardReciept.displayMobNum(mobNum);
        //cardReciept.displaySubTotal(Float.parseFloat(subTotal));
        //cardReciept.displayDiscount(Float.parseFloat(discount));
        //cardReciept.displayTotal(Float.parseFloat(total));
        //cardReciept.displayPaidAmount(Float.parseFloat(paidAmnt));

        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEdit() throws IOException {
        Main main = new Main();
        main.changeScene("MenuPage.fxml", "Dave's Burger");
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

    //validate card inputs when the Save button is pressed
    public void SaveBtnAction(ActionEvent event){
        boolean cardNumValidator = DataValidator.cardNumFormat(cardNumTextField, cardNumLabel,"Format must be XXXX-XXXX-XXXX-XXXX from 0-9");
        boolean cardCVV_Validator = DataValidator.cardCVVFormat(CVVTextField, CVVLabel, "Format must be *** from 0-9");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        YearNum.getItems().addAll(years);
        MonthNum.getItems().addAll(months);
    }


}
