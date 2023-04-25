package src;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminPageController implements Initializable {
    @FXML
    private Button balance_btn;

    @FXML
    private AnchorPane balance_scene;

    @FXML
    private TableColumn<?, ?> category_col;

    @FXML
    private PieChart category_pie;

    @FXML
    private Button empAdd_btn;

    @FXML
    private TableView<?> empData;

    @FXML
    private TableColumn<?, ?> empID_col;

    @FXML
    private TableColumn<?, ?> empName_col;

    @FXML
    private TableColumn<?, ?> empPos_col;

    @FXML
    private Button empRemove_btn;

    @FXML
    private TableColumn<?, ?> empSal_col;

    @FXML
    private Button generate_btn;

    @FXML
    private TableColumn<?, ?> itemID_col;

    @FXML
    private TableColumn<?, ?> itemName_col;

    @FXML
    private TableColumn<?, ?> itemPrice_col;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private Button menuAdd_btn;

    @FXML
    private TableView<?> menuData;

    @FXML
    private Button menuEdit_btn;

    @FXML
    private Button menuRemove_btn;

    @FXML
    private AnchorPane menuUpdate_scene;

    @FXML
    private Button menu_btn;

    @FXML
    private AnchorPane orderVol;

    @FXML
    private BarChart<?, ?> orderVolBar;

    @FXML
    private Button report_btn;

    @FXML
    private AnchorPane report_scene;

    @FXML
    private AreaChart<?, ?> saleDataLine;

    @FXML
    private AreaChart<?, ?> saleThisWeek_line;

    @FXML
    private Button team_btn;

    @FXML
    private AnchorPane team_scene;

    @FXML
    private Button timecard_btn;

    @FXML
    private AnchorPane todayDate;

    @FXML
    private AnchorPane todaySale;

    @FXML
    private TableColumn<?, ?> totalHour_col;


    public void logout_btn() throws IOException {
        Main main = new Main();
        main.changeScene("LoginPage.fxml", "LoginPage");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}

