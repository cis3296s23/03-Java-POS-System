package src;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * class used to validate the data of payment data
 */
public class DataValidator {
    @FXML
    private Label nameLabel, PayInfoLabel, mobileNumLabel, cardNumLabel, ExpDateLabel, CVVLabel, rewardsLabels;

    @FXML
    private TextField nameTextField, mobileNumTextField, cardNumTextField, ExpDateTextField, CVVTextField;

    @FXML
    private RadioButton tenPercentOffRadioBtn, fifteenPercentOffRadioBtn,twentyPercentOffRadioBtn;

    @FXML
    private Button customButton, saveButton;

    @FXML
    private TableView<Item> yourOrderTableView;

    @FXML
    private TextField subTotalTextField, discountTextField, totalTextField;

    @FXML
    private Label totalLabel, yourOrderLabel, subTotalLabel, discountLabel;

    @FXML
    private Button processPaymentButton;

    @FXML
    private Button backButton;


    /**
     * card Num validation
     * @param cardNumTextField holds card number data
     * @param cardNumLabel label to write validation text
     * @param validateText message to write to the GUI that confirms the data is valid
     * @return boolean for success
     */
    public static boolean cardNumFormat(TextField cardNumTextField, Label cardNumLabel, String validateText){
        boolean isCardNum = true;
        String validationstring = null;

        if(!cardNumTextField.getText().matches("\"^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}$\"gm")){
            isCardNum = false;
            validationstring = validateText;
        }

        cardNumLabel.setText(validationstring);
        return isCardNum;
    }


    /**
     * card CVV validation
     * @param CVVTextField holds card CVV data
     * @param CVVLabel label to write validation text
     * @param validateText message to write to the GUi that confirms the data is valid
     * @return boolean for success
     */
    public static boolean cardCVVFormat(TextField CVVTextField, Label CVVLabel, String validateText){
        boolean isCardNum = true;
        String validationstring = null;

        if (!CVVTextField.getText().matches("\"^[0-9]{3}$\"gm")){
            isCardNum = false;
            validationstring = validateText;
        }
        CVVLabel.setText(validationstring);
        return isCardNum;
    }
}
