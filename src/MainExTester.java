package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * tests a scene transition
 */
public class MainExTester extends Application {
    /**
     * called when the main ex tester starts to run
     * @param stage stage to set the scene to
     * @throws Exception if the given page's fxml file cannot be found, an exception is thrown
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PayMethod.fxml"));
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
