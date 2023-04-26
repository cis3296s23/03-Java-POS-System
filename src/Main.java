package src;

import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//extends application for JavaFX
public class Main extends Application {
    private static Stage stage;
    public static void main(String[] args) {

        System.out.println("\tDATABASE CREATION");

        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Dave's Burger");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //change scene as needed

    public void changeScene(String fxml, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

}// end main