package src;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.swing.text.TableView;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller for CardReciept.fxml
 */
public class CardReciept implements Initializable {
    @FXML
    Label DBLabel, orderNumLabel, custRecieptLabel, mobNumLabel;
    @FXML
    Label custNameLabel, paidAmountLabel;
    @FXML
    TableView orderTableView;
    @FXML
    Label subTotalLabel;
    @FXML
    Label  discountLabel;
    @FXML
    Label totalLabel;

    /**
     * sets custNameLabel to the parameter
     * @param custName string which represents the name of the customer
     */
    public void displayCustName(String custName){
        custNameLabel.setText(custName);
    }

    /**
     * sets mobNumLabel to the parameter
     * @param mobNum string which represents the mobile number of the customer
     */
    public void displayMobNum(String mobNum){
        mobNumLabel.setText( mobNum);
    }

    /**
     * sets subTotalLabel to the parameter
     * @param subTotal float which represents the subtotal of the order
     */
    public void displaySubTotal(float subTotal){
        subTotalLabel.setText(String.valueOf(subTotal));
    }

    /**
     * sets discountLabel to the parameter
     * @param discount float which represents the discount to be applied to the order
     */
    public void displayDiscount(float discount){
        discountLabel.setText(String.valueOf(discount));
    }

    /**
     * sets totalLabel to the parameter
     * @param total float which represents the order's total amount owed
     */
    public void displayTotal(float total){
        totalLabel.setText(String.valueOf(total));
    }

    /**
     * sets paidAmountLabel to the parameter
     * @param paidAmnt float which represents the amount paid by the customer
     */
    public void displayPaidAmount(float paidAmnt){
        paidAmountLabel.setText(String.valueOf(paidAmnt));
    }

    /**
     * when the page is initialized, this method is called
     * @param location refer to the Initializable interface from the JavaFX fxml library
     * @param resources refer to the Initializable interface from the JavaFX fxml library
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
