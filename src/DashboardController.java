package src;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DashboardController {
    @FXML
    private Label welcomeText;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Button menu, updateMenu, balance, clockIn, report, transaction, setting, logout;

    @FXML
    Stage stage;

}
