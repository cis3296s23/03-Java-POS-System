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
 * controller for PayMethod.fxml
 */
public class PayMethod implements Initializable {

    /**
     * when the page is initialized, this method is called
     * @param location refer to the Initializable interface from the JavaFX fxml library
     * @param resources refer to the Initializable interface from the JavaFX fxml library
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private Stage stage;
    private Scene scene;
    private  Parent root;

    /**
     * changes the scene on the current stage to the Cash Pay page
     * @throws IOException if the given page's fxml file cannot be found, an exception is thrown
     */
    public void switchToCashPay() throws IOException{
        Main main = new Main();
        main.changeScene("CashPay.fxml", "Dave's Burger");
    }

    /**
     * changes the scene on the current stage to the Card Pay page
     * @throws IOException if the given page's fxml file cannot be found, an exception is thrown
     */
    public void switchToCardPay() throws IOException{
        Main main = new Main();
        main.changeScene("CardPay.fxml", "Dave's Burger");
    }

    /**
     * changes the scene on the current stage to the Menu page
     * @throws IOException if the given page's fxml file cannot be found, an exception is thrown
     */
    public void goBack() throws IOException {
        Main main = new Main();
        main.changeScene("MenuPage.fxml", "Dave's Burger");
    }

}
