package src;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.swing.text.TableView;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller for CashReceipt.fxml
 */
public class CashReciept implements Initializable {
    @FXML
    Label DBLabel, orderNumLabel, custRecieptLabel, mobNumLabel;
    @FXML
    Label custNameLabel, paidAmountLabel;
    @FXML
    TableView orderTableView;
    @FXML
    Label subTotalLabel;
    @FXML
    Label discountLabel;
    @FXML
    Label totalLabel;

    /**
     * sets custNameLabel to the parameter
     * @param custName string containing the name of the customer
     */
    public void displayCustName(String custName){
        custNameLabel.setText(custName);
    }

    /**
     * sets mobNumLabel to the parameter
     * @param mobNum string containing the mobile number of the customer
     */
    public void displayMobNum(String mobNum){
        mobNumLabel.setText( mobNum);
    }

    /**
     * sets subTotalLabel to the parameter
     * @param subTotal float containing the subtotal of the customer's order
     */
    public void displaySubTotal(float subTotal){
        subTotalLabel.setText("SubTotal: $" +String.valueOf(subTotal));
    }

    /**
     * sets discountLabel to the parameter in the format: "Discount:  $[discount]"
     * @param discount float containing the size of the discount
     */
    public void displayDiscount(float discount){
        discountLabel.setText("Discount:  $"+String.valueOf(discount));
    }

    /**
     * sets totalLabel to the parameter in the format: "Total: $[total]"
     * @param total float containing the total of the customer's order
     */
    public void displayTotal(float total){
        totalLabel.setText("Total: $" + String.valueOf(total));
    }

    /**
     * sets paidAmountLabel to the parameter in the format: "Paid Amount: $[paidAmount]"
     * @param paidAmnt float containing the total amount that the customer has paid
     */
    public void displayPaidAmount(float paidAmnt){
        paidAmountLabel.setText("Paid Amount: $"+String.valueOf(paidAmnt));
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
