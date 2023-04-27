package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class MainExTester extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PayMethod.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        Scene paymentMethodScene = new Scene(root);

        stage.setScene(paymentMethodScene);
        stage.setTitle("Dave's Burger");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
