package src;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * main class of the program, extends application for JavaFX
 */
public class Main extends Application {
    private static Stage stage;
    public static void main(String[] args) {


        System.out.println("\tDATABASE CREATION");

        Database db = new Database();
        Connection conn = db.connectToDB(true);

        db.createInitialTables(conn);
        launch(args);
    }

    /**
     * when launch() is called, the first page is initialized
     * @param primaryStage the stage to host the elements of the application
     * @throws Exception if the given page's fxml file cannot be found, an exception is thrown
     */
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

    /**
     * changes the scene on the stage to an fxml file's data
     * @param fxml fxml file to use
     * @param title name of the stage to use
     * @throws IOException if the given page's fxml file cannot be found, an exception is thrown
     */
    public void changeScene(String fxml, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

}// end main