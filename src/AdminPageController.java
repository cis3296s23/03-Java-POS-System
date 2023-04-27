package src;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminPageController implements Initializable {
    @FXML
    private Button balance_btn;

    @FXML
    private AnchorPane balance_scene;

    @FXML
    private TableColumn<Menu, String> category_col;

    @FXML
    private PieChart category_pie;

    @FXML
    private Button empAdd_btn;

    @FXML
    private TableView<EmployeesData> empData_table;

    @FXML
    private TableColumn<EmployeesData, String> empID_col;

    @FXML
    private TextField empID_txt;

    @FXML
    private TableColumn<EmployeesData, String> empName_col;

    @FXML
    private TextField empName_txt;

    @FXML
    private TextField empPhone_txt;
    @FXML
    private TableColumn<EmployeesData, String> empPhone_col;

    @FXML
    private TableColumn<EmployeesData, String> empPos_col;

    @FXML
    private Button empRemove_btn;

    @FXML
    private TableColumn<EmployeesData, String> empSal_col;

    @FXML
    private DatePicker fromDate_txt;

    @FXML
    private Button generate_btn;

    @FXML
    private TableColumn<Menu, Integer> itemID_col;

    @FXML
    private TableColumn<Menu, String> itemName_col;

    @FXML
    private TableColumn<Menu, Double> itemPrice_col;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private Button menuAdd_btn;

    @FXML
    private TableView<Menu> menuData;

    @FXML
    private Button menuEdit_btn;

    @FXML
    private Button menuRemove_btn;

    @FXML
    private AnchorPane menuUpdate_scene;

    @FXML
    private Button menu_btn;

    @FXML
    private Label name_label;

    @FXML
    private AnchorPane orderVol;

    @FXML
    private BarChart<String, Integer> orderVol_bar;

    @FXML
    private ChoiceBox<String> position_choice;

    @FXML
    private Button report_btn;

    @FXML
    private AnchorPane report_scene;

    @FXML
    private TextField salary_txt;

    @FXML
    private AreaChart<?, ?> saleData_line;

    @FXML
    private AreaChart<?, ?> saleThisWeek_line;

    @FXML
    private Button team_btn;

    @FXML
    private AnchorPane team_scene;

    @FXML
    private DatePicker toDate_txt;

    @FXML
    private AnchorPane todayDate;

    @FXML
    private AnchorPane todaySale;

    @FXML
    private TableColumn<?, ?> totalHour_col;

    @FXML
    private Label saleLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label orderLabel;

    @FXML
    private TextField itemID_txt;

    @FXML
    private TextField itemName_txt;

    @FXML
    private TextField itemPrice_txt;

    @FXML
    private ComboBox<String> category_choice;

    @FXML
    private Label saleAmount_btn;

    @FXML
    private Label error_label;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Alert alert;

    private String[] choice = {"Chef","Cashier","Prep"};
    private String[] category = {"Burger", "Drinks", "Extras", "Wrap and Salads", "Steak", "EggRolls"};

    //this is a remove button to remove any menu items
    public void removeMenuBtn(){
        if (itemID_txt.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to REMOVE Item ID: " + itemID_txt.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            // CHECK PRODUCT ID
            String checkEmp = "SELECT item_id FROM menu WHERE item_id = '"
                    + itemID_txt.getText() + "'";

            connect = Database.connectToDB(false);

            try {

                statement = connect.createStatement();
                result = statement.executeQuery(checkEmp);

                if (!result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(itemID_txt.getText() + " cannot be found!");
                    menuClearBtn();
                    alert.showAndWait();
                } else if (option.get().equals(ButtonType.OK)) {

                    String deleteData = "DELETE FROM menu WHERE item_id = " + itemID_txt.getText();
                    prepare = connect.prepareStatement(deleteData);
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Deleted Successfully!");
                    alert.showAndWait();

                    // TO UPDATE YOUR TABLE VIEW
                    menuShowData();
                    menuClearBtn();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //this button will add new menu item to the menu
    public void addMenuBtn() {

        if (itemID_txt.getText().isEmpty()
                || itemName_txt.getText().isEmpty()
                || itemPrice_txt.getText().isEmpty()
                || category_choice.getSelectionModel().getSelectedItem() == null) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else{
            //check for the item id in table menu
            String checkEmp = "SELECT item_id FROM menu WHERE item_id = '"
                    + itemID_txt.getText() + "'";

            connect = Database.connectToDB(false);

            try {

                statement = connect.createStatement();
                result = statement.executeQuery(checkEmp);
                //check to see if the id is taken and show error message if does
                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(itemID_txt.getText() + " is already taken");
                    alert.showAndWait();
                } else {
                    //if item is not taken then proceed inserting data into menu
                    String insertData = "INSERT INTO menu "
                            + "(item_id, item_name, category, item_price) "
                            + "VALUES(?,?,?,?)";

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, itemID_txt.getText());
                    prepare.setString(2, itemName_txt.getText());
                    prepare.setString(3, (String) category_choice.getSelectionModel().getSelectedItem());
                    prepare.setString(4, itemPrice_txt.getText());


                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    menuShowData();
                    menuClearBtn();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private ObservableList<Menu> menuList;
    //this show data on the table according to our data on the database
    public void menuShowData() {
        menuList = menuDataList();

        itemID_col.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        itemName_col.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
        itemPrice_col.setCellValueFactory(new PropertyValueFactory<>("Price"));
        category_col.setCellValueFactory(new PropertyValueFactory<>("Category"));

        menuData.setItems(menuList);

    }
    //this method is to retrieve data from our database
    public ObservableList<Menu> menuDataList() {

        ObservableList<Menu> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM menu";

        connect = Database.connectToDB(false);

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            Menu menuData;

            while (result.next()) {

                menuData = new Menu(result.getInt("item_id"),
                        result.getString("item_name"),
                        result.getString("category"),
                        result.getDouble("item_price"));

                listData.add(menuData);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    //this method will clear all the textfields when called
    public void menuClearBtn() {

        itemID_txt.setText("");
        itemName_txt.setText("");
        itemPrice_txt.setText("");
        category_choice.getSelectionModel().clearSelection();

    }
    //display current date to the designated label
    public void balanceDisplayDate() {

        // Get the current date
        LocalDate currentDate = LocalDate.now();
        // Set the label's text to the current date
        dateLabel.setText(currentDate.toString());
    }

    //display todays sale to the desginated label
    public void balanceDisplaySale(){

        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "SELECT SUM(order_total) FROM orders WHERE order_date = '"
                + sqlDate + "'";

        connect = Database.connectToDB(false);

        try {
            double todaySale = 0;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                todaySale = result.getDouble("SUM(order_total)");
            }

            saleLabel.setText("$" + todaySale);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //display today order volume to the desginated label
    public void balanceDisplayOrder(){

        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "SELECT COUNT(order_id) FROM orders WHERE order_date = '"
                + sqlDate + "'";
        connect = Database.connectToDB(false);

        try {
            int orderNum = 0;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                orderNum = result.getInt("COUNT(order_id)");
            }
            orderLabel.setText(String.valueOf(orderNum));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //display the sale chart for the last 7 days
    public void balanceDisplayChart(){
            saleThisWeek_line.getData().clear();

        // Select the total sale for the last 7 days
        String sql = "SELECT order_date, SUM(order_total) " +
                "FROM orders " +
                "WHERE order_date >= DATE(NOW()) - INTERVAL 7 DAY " +
                "GROUP BY order_date " +
                "ORDER BY TIMESTAMP(order_date)";

            connect = Database.connectToDB(false);
            XYChart.Series chart = new XYChart.Series();
            try {
                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();

                while (result.next()) {
                    chart.getData().add(new XYChart.Data<>(result.getString(1), result.getFloat(2)));
                }

                saleThisWeek_line.getData().add(chart);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    //this method will remove any employee from our database and table
    public void removeEmpBtn() {
        if (empID_txt.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to REMOVE Employees ID: " + empID_txt.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            // CHECK PRODUCT ID
            String checkEmp = "SELECT item_id FROM employees WHERE item_id = '"
                    + empID_txt.getText() + "'";

            connect = Database.connectToDB(false);

            try {

                statement = connect.createStatement();
                result = statement.executeQuery(checkEmp);

                if (!result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(empID_txt.getText() + " cannot be found!");
                    empClearBtn();
                    alert.showAndWait();
                } else if (option.get().equals(ButtonType.OK)) {

                    String deleteData = "DELETE FROM employees WHERE item_id = " + empID_txt.getText();
                    prepare = connect.prepareStatement(deleteData);
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Deleted Successfully!");
                    alert.showAndWait();

                    // update the tableview
                    employeesShowData();
                    empClearBtn();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //add employee to our database and table
    public void addEmpBtn() {

        if (empID_txt.getText().isEmpty()
                || empName_txt.getText().isEmpty()
                || salary_txt.getText().isEmpty()
                || position_choice.getSelectionModel().getSelectedItem() == null) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else{
                //check for item id if exist then connect to our database
                String checkEmp = "SELECT item_id FROM employees WHERE item_id = '"
                        + empID_txt.getText() + "'";

                connect = Database.connectToDB(false);

                try {

                    statement = connect.createStatement();
                    result = statement.executeQuery(checkEmp);

                    if (result.next()) {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText(empID_txt.getText() + " is already taken");
                        alert.showAndWait();
                    } else {
                        String insertData = "INSERT INTO employees "
                                + "(item_id, full_name, email, salary, position) "
                                + "VALUES(?,?,?,?,?)";

                        prepare = connect.prepareStatement(insertData);
                        prepare.setString(1, empID_txt.getText());
                        prepare.setString(2, empName_txt.getText());
                        prepare.setString(3, empPhone_txt.getText());
                        prepare.setString(4, salary_txt.getText());
                        prepare.setString(5, (String) position_choice.getSelectionModel().getSelectedItem());

                        prepare.executeUpdate();

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Added!");
                        alert.showAndWait();

                        employeesShowData();
                        empClearBtn();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    //retrieve data from table employees on our database
    public ObservableList<EmployeesData> employeesDataList() {

        ObservableList<EmployeesData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM employees";

        connect = Database.connectToDB(false);

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            EmployeesData empData;

            while (result.next()) {

                empData = new EmployeesData(result.getString("item_id"),
                        result.getString("full_name"),
                        result.getString("email"),
                        result.getDouble("salary"),
                        result.getString("position"));

                listData.add(empData);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<EmployeesData> employeesList;
    //show all of our employee data on the table
    public void employeesShowData() {
        employeesList = employeesDataList();

        empID_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        empName_col.setCellValueFactory(new PropertyValueFactory<>("empName"));
        empPhone_col.setCellValueFactory(new PropertyValueFactory<>("phone"));
        empPos_col.setCellValueFactory(new PropertyValueFactory<>("position"));
        empSal_col.setCellValueFactory(new PropertyValueFactory<>("salary"));

        empData_table.setItems(employeesList);

    }
    //clear all the input textfield when called
    public void empClearBtn() {

        empID_txt.setText("");
        empName_txt.setText("");
        empPhone_txt.setText("");
        salary_txt.setText("");
        position_choice.getSelectionModel().clearSelection();

    }
    @FXML
    public void handleShowChart(ActionEvent event) {
        LocalDate startDate = fromDate_txt.getValue();
        LocalDate endDate = toDate_txt.getValue();
        showAreaChart(startDate, endDate);
        showPieChart(startDate, endDate);
        showBarChart(startDate, endDate);
        error_label.setText("");

        if (startDate != null && endDate != null) {
            if (startDate.isAfter(endDate)) {
                // display error message if start date is after end date
                showErrorDialog("Invalid date range", "Start date must be before end date.");

            } else {
                // show area chart for the selected date range
                showAreaChart(startDate, endDate);
                showPieChart(startDate, endDate);
                showBarChart(startDate, endDate);

            }
        } else {
            // display error message if date range is not selected
            showErrorDialog("Missing date range", "Please select a start and end date.");
        }
    }
    private void showErrorDialog(String title, String message) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //show area chart within specific data range
    public void showAreaChart(LocalDate startDate, LocalDate endDate){
        saleData_line.getData().clear();
        String areaSql = "SELECT order_date, SUM(order_total) FROM orders " +
                "WHERE order_date BETWEEN ? AND ? " +
                "GROUP BY order_date ORDER BY TIMESTAMP(order_date)";

        connect = Database.connectToDB(false);
        XYChart.Series chart = new XYChart.Series();
        try {
            prepare = connect.prepareStatement(areaSql);
            prepare.setString(1, startDate.toString());
            prepare.setString(2, endDate.toString());
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getFloat(2)));
            }

            saleData_line.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showPieChart(LocalDate startDate, LocalDate endDate) {
        category_pie.getData().clear();
        String sql = "SELECT oi.category, SUM(oi.item_quantity) AS total_quantity_sold " +
                "FROM ordereditems oi " +
                "JOIN orders o ON oi.order_id = o.order_id " +
                "WHERE o.order_date BETWEEN ? AND ? " +
                "GROUP BY oi.category";

        connect = Database.connectToDB(false);
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, startDate.toString());
            prepare.setString(2, endDate.toString());
            result = prepare.executeQuery();

            // Create a new pie chart
            PieChart chart = new PieChart();

            // Add data to the chart
            while (result.next()) {
                String category = result.getString("category");
                int totalQuantitySold = result.getInt("total_quantity_sold");
                chart.getData().add(new PieChart.Data(category + " (" + totalQuantitySold + ")", totalQuantitySold));

            }

            // Set title and legend for the chart
            chart.setTitle("Items Sold by Category and Quantity");
            chart.setLegendVisible(true);

            // Add the chart to the container node and show it
            category_pie.getData().clear();
            category_pie.getData().addAll(chart.getData());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showBarChart(LocalDate startDate, LocalDate endDate) {
        orderVol_bar.getData().clear();
        String barSql = "SELECT order_date, COUNT(order_id) FROM orders " +
                "WHERE order_date BETWEEN ? AND ? " +
                "GROUP BY order_date ORDER BY TIMESTAMP(order_date)";

        connect = Database.connectToDB(false);
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        try {
            prepare = connect.prepareStatement(barSql);
            prepare.setString(1, startDate.toString());
            prepare.setString(2, endDate.toString());
            result = prepare.executeQuery();
            boolean hasData = false;
            while (result.next()) {
                series.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
                hasData = true;
            }
            if (!hasData) {
                error_label.setText("No data found for selected date range");
                saleAmount_btn.setText("0");
            } else {
                orderVol_bar.getData().add(series);
                error_label.setText("");

                // Set vertical axis to only show integer values
                Axis yAxis = orderVol_bar.getYAxis();
                if (yAxis instanceof NumberAxis) {
                    NumberAxis numberAxis = (NumberAxis) yAxis;
                    numberAxis.setTickUnit(1);
                    numberAxis.setForceZeroInRange(false); // Set to false to prevent from forcing the axis to show zero
                    numberAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(numberAxis) {
                        @Override
                        public String toString(Number object) {
                            return String.format("%d", object.intValue());
                        }
                    });
                }}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //log out button on admin access page
    public void logout_btn() throws IOException {
        Main main = new Main();
        main.changeScene("Dashpage.fxml", "Dashboard");
    }
    //this method will swithc multiple anchorpane according to each associated buttons
    public void switchForm(ActionEvent event) {

        if (event.getSource() == report_btn) {
            report_scene.setVisible(true);
            balance_scene.setVisible(false);
            team_scene.setVisible(false);
            menuUpdate_scene.setVisible(false);


        } else if (event.getSource() == menu_btn) {
            report_scene.setVisible(false);
            balance_scene.setVisible(false);
            team_scene.setVisible(false);
            menuUpdate_scene.setVisible(true);

            menuShowData();


        } else if (event.getSource() == team_btn) {
            report_scene.setVisible(false);
            balance_scene.setVisible(false);
            team_scene.setVisible(true);
            menuUpdate_scene.setVisible(false);

            employeesShowData();


        } else  if (event.getSource() == balance_btn) {
            report_scene.setVisible(false);
            balance_scene.setVisible(true);
            team_scene.setVisible(false);
            menuUpdate_scene.setVisible(false);

        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        category_choice.getItems().addAll(category);
        position_choice.getItems().addAll(choice);

        saleData_line.getData().clear();
        orderVol_bar.getData().clear();
        category_pie.getData().clear();

        saleAmount_btn.setText("0");
        error_label.setText("");

        employeesShowData();
        balanceDisplayDate();
        balanceDisplaySale();
        balanceDisplayOrder();
        balanceDisplayChart();
        menuShowData();
    }
}

