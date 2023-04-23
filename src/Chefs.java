package src;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Chefs {

    private Stage stage;

    public Chefs(Stage stage) {
        this.stage = stage;
    }

    public void showChefsPage(Order order) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChefsPage.fxml"));
        BorderPane root = loader.load();

        // Get the table view from the FXML file
        TableView<Item> orderTable = (TableView<Item>) root.lookup("#orderTable");

        // Populate the table view with the items from the order
        ObservableList<Item> items = FXCollections.observableArrayList();
        orderTable.setItems(items);

        // Set the new scene in the main stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Chefs Page");
        stage.show();
    }
}
