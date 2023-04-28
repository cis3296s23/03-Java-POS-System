package src;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.swing.text.TableView;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller for CardReceipt.fxml
 */
public class CardReciept implements Initializable {
    @FXML
    Label DBLabel, orderNumLabel, custRecieptLabel, mobNumLabel;
    @FXML
    TableView orderTableView;
    @FXML
    Label subTotalLabel, discountLabel, totalLabel;

    /**
     * displays the receipt to the GUI
     * @param custName name of the customer
     * @param mobNum mobile number of the customer
     */
    public void displayReciept(String custName, String mobNum ){
        custRecieptLabel.setText(custName +  "'s Receipt");
        mobNumLabel.setText("Mobile Number: " + mobNum);

    }

    /**
     * on launch of the page, this method is called
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
