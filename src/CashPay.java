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

public class CashPay implements Initializable{
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    private Stage stage;
    private Scene scene;
    private  Parent root;

    // Implemented the back button to return back to the Payment Page
    public void switchBackToPaymentMethod(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PayMethod.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Get receipt when proceed to payment
    public void getReciept(ActionEvent event) throws IOException {
        //root = FXMLLoader.load(getClass().getResource("PaymentMethod.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
