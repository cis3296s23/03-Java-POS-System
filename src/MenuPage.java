package src;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * holds method used to display the menu page
 */
public class MenuPage {
    /**
     * sets the scene to the menu page
     * @param primaryStage current stage of the application
     */
    public void display(Stage primaryStage) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));

            Scene menuPage = new Scene(root);
            primaryStage.setScene(menuPage);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);

        }
    }
}
