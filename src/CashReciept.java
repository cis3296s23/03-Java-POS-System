package src;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.swing.text.TableView;
import java.net.URL;
import java.util.ResourceBundle;

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

    public void displayCustName(String custName){
        custNameLabel.setText(custName);
    }

    public void displayMobNum(String mobNum){
        mobNumLabel.setText( mobNum);
    }

    public void displaySubTotal(float subTotal){
        subTotalLabel.setText("SubTotal: $" +String.valueOf(subTotal));
    }

    public void displayDiscount(float discount){
        discountLabel.setText("Discount:  $"+String.valueOf(discount));
    }

    public void displayTotal(float total){
        totalLabel.setText("Total: $" + String.valueOf(total));
    }

    public void displayPaidAmount(float paidAmnt){
        paidAmountLabel.setText("Paid Amount: $"+String.valueOf(paidAmnt));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
