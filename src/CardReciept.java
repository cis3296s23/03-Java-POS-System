package src;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.swing.text.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class CardReciept implements Initializable {
    @FXML
    Label DBLabel, orderNumLabel, custRecieptLabel, mobNumLabel;
    @FXML
    TableView orderTableView;
    @FXML
    Label subTotalLabel, discountLabel, totalLabel;

    public void displayReciept(String custName, String mobNum ){
        custRecieptLabel.setText(custName +  "'s Receipt");
        mobNumLabel.setText("Mobile Number: " + mobNum);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
