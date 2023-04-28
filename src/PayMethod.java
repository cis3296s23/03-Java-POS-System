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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//extends application for JavaFX

/**
 * controller of Paymethod.fxml
 */
public class PayMethod implements Initializable {
    /**
     * when the page is intitialized, this method is called
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private Stage stage;
    private Scene scene;
    private  Parent root;

    /**
     * switches the scene to the cash pay page
     * @param event
     * @throws IOException
     */
    public void switchToCashPay(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("CashPay.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * switches the scene to the car pay page
     * @param event
     * @throws IOException
     */
    public void switchToCardPay(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("CreditDebitCardPay.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * switches the scene to the menu page
     * @param event
     * @throws IOException
     */
    public void goBack(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
