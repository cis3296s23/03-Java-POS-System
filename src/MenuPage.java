package src;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuPage {

    public void display(Stage primaryStage) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));

            Scene menuPage = new Scene(root);
            primaryStage.setScene(menuPage);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
