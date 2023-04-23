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

public class LoginController implements Initializable {

    @FXML
    private Button login_btn;

    @FXML
    private PasswordField password_txt;

    @FXML
    private TextField username_txt;

    private Alert alert;
    private String user = "admin";
    private String pass = "admin123";
    private Main main = new Main();

    public void loginBt() throws IOException {

        if (username_txt.getText().isEmpty() || password_txt.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect Username/Password");
            alert.showAndWait();
        } else if (username_txt.getText().equals(user) && password_txt.getText().equals(pass)){
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

    public void dashboardBtn() throws IOException {
        main.changeScene("DashPage.fxml", "Dashboard");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}



