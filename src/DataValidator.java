package src;

import javafx.fxml.FXML;
import javafx.scene.control.*;

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


    // card Num validation
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


    // card CVV validation
    public static boolean cardCVVFormat(TextField CVVTextField, Label CVVLabel, String validateText){
        boolean isCardCVV = true;
        String validationstring = null;

        if (!CVVTextField.getText().matches("\"^[0-9]{3}$\"gm")){
            isCardCVV = false;
            validationstring = validateText;
        }
        CVVLabel.setText(validationstring);
        return isCardCVV;
    }
}
