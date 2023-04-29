package src;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller for LoginPage.fxml
 */
public class LoginController implements Initializable {

    @FXML
    private Button login_btn;

    @FXML
    private Button dashboardBtn;

    @FXML
    private PasswordField password_txt;

    @FXML
    private TextField username_txt;

    private Alert alert;
    private String user = "admin";
    private String pass = "admin123";
    private Main main = new Main();

    /**
     * uses the text in the username and password text fields to attempt to log in
     * @throws IOException if the given page's fxml file cannot be found, an exception is thrown
     */
    public void loginBt() throws IOException {

        if (username_txt.getText().equals(user) && password_txt.getText().equals(pass)){
            main.changeScene("AdminPage.fxml", "Admin Access");
        }
        else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect Username/Password");
            alert.showAndWait();
        }
    }

    /**
     * changes the scene to the dashboard
     * @throws IOException if the given page's fxml file cannot be found, an exception is thrown
     */
    public void dashboardBtn() throws IOException {
        main.changeScene("DashPage.fxml", "Dashboard");
    }

    /**
     * when the page is initialized, this method is called
     * @param url refer to the Initializable interface from the JavaFX fxml library
     * @param rb refer to the Initializable interface from the JavaFX fxml library
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}



