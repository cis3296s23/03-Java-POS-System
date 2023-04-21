package src;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//extends application for JavaFX
public class Main extends Application {

    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306";
    //make sure your local server is on and username and password are the according to this below
    static String user = "root";
    static String passwordDB = "Yellow6936Tail!";
    public static void main(String[] args) {
        //an array of string to hold the menu data
        String[][] menuItems = {
                {"1", "Bacon Burger", "Burgers", "13.00"},
                {"2", "Salmon BLT", "Burgers", "16.75"},
                {"3", "Brunch Burger", "Burgers", "16.80"},
                {"4", "The Goat", "Burgers", "17.00"},
                {"5", "Chicken Cheesesteak", "Steak", "13.00"},
                {"6", "Phillys Cheesesteak", "Steak", "15.00"},
                {"7", "Salmon Rolls", "EggRolls", "10.00"},
                {"8", "Shrimp Rolls", "EggRolls", "10.00"},
                {"9", "Chicken Rolls", "Egg Rolls", "8.00"},
                {"10", "Extra Mayo", "Extras", "1.00"},
                {"11", "Sauteed Spinach", "Extras", "1.00"},
                {"12", "Turkey Bacon", "Extras", "2.00"},
                {"13", "Beef Bacon", "Extras", "2.00"},
                {"14", "Extra Cheese", "Extras", "1.50"},
                {"15", "Teriyaki Sauce", "Side Sauce", "1.00"},
                {"16", "Sweet Chilli Sauce", "Side Sauce", "1.00"},
                {"17", "Extra BBQ Sauce", "Side Sauce", "1.00"},
                {"18", "Sweet Potato Dipping Sauce", "Side Sauce", "1.00"},
                {"19", "Wraps", "Wraps and Salads", "10.00"},
                {"20", "Salads", "Wraps and Salads", "10.00"},
                {"21", "Lemonade", "Drinks", "3.00"},
                {"22", "Soft Drinks", "Drinks", "3.00"},
                {"23", "Water", "Drink", "2.00"},
                {"24", "Bacon Burger", "Burgers", "13.00"},
                {"25", "Salmon BLT", "Burgers", "16.75"},
                {"26", "Brunch Burger", "Burgers", "16.80"},
                {"27", "The Goat", "Burgers", "17.00"},
                {"28", "Salmon Rolls", "EggRolls", "10.00"},
                {"29", "Shrimp Rolls", "EggRolls", "10.00"},
                {"30", "Chicken Rolls", "Egg Rolls", "8.00"},
                {"31", "Extra Mayo", "Extras", "1.00"},
                {"32", "Sauteed Spinach", "Extras", "1.00"},
                {"33", "Turkey Bacon", "Extras", "2.00"},
                {"34", "Beef Bacon", "Extras", "2.00"},
                {"35", "Extra Cheese", "Extras", "1.50"},
                {"36", "Teriyaki Sauce", "Side Sauce", "1.00"},
                {"37", "Sweet Chilli Sauce", "Side Sauce", "1.00"},
                {"38", "Extra BBQ Sauce", "Side Sauce", "1.00"},
                {"39", "Sweet Potato Dipping Sauce", "Side Sauce", "1.00"},
                {"40", "Wraps", "Wraps and Salads", "10.00"},
                {"41", "Salads", "Wraps and Salads", "10.00"},
                {"42", "Lemonade", "Drinks", "3.00"},
                {"43", "Soft Drinks", "Drinks", "3.00"},
                {"44", "Water", "Drink", "2.00"}};

        //an array of string to hold employees data
        String[][] employees = {{"1111", "John Smith", "john@temple.edu", "16.00", "Cashier"},
                {"1112", "Jane Doe", "jane@temple.edu", "16.00", "Cashier"},
                {"1113", "Kyle Walker", "kyle@temple.edu", "20.00", "Chef"},
                {"1114", "Jack Grealish", "jack@temple.edu", "25.00", "HeadChef"}};

        System.out.println("\tDATABASE CREATION");

       /* String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306";
        //make sure your local server is on and username and password are the according to this below
        String user = "root";
        String passwordDB = "Yellow6936Tail!"; */

        //create an instance for Database class
        Database database = null;

        try {
            database = new Database(url, user, passwordDB, menuItems, employees);
            database.createDatabase();
            System.out.println("***************************************");
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } finally {
            if (database != null) {
                try {
                    database.close();
                } catch (SQLException e) {
                    System.err.println("Error closing database connection: " + e.getMessage());
                }
            }
        }
        //for start()
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene login = firstLogin(primaryStage);
        // show the initial login window
        primaryStage.setScene(login);
        primaryStage.show();
    }

    /*
    creates the login page for the first login required of the user
     */
    public Scene firstLogin(Stage primaryStage) {
        User admin = new User("admin", "admin123");

        // make new grid where labels, fields, buttons, etc. are placed (login page)
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(20);
        grid.setHgap(20);

        // set column constraints for the grid
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(30);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(70);
        grid.getColumnConstraints().addAll(column1, column2);

        // create the scenes where the grids will appear
        Scene login = new Scene(grid);
        GridPane dashboardGrid = new GridPane();
        Scene dashboard = new Scene(dashboardGrid);

        // make Log In label
        final Label loginLabel = new Label();
        loginLabel.setText("Log In");
        loginLabel.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        GridPane.setConstraints(loginLabel, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER);
        grid.getChildren().add(loginLabel);

        // make admin name label
        final Label adminNameLabel = new Label();
        adminNameLabel.setText("Admin");
        GridPane.setConstraints(adminNameLabel, 0, 1, 1, 1, HPos.RIGHT, VPos.CENTER);
        grid.getChildren().add(adminNameLabel);

        // make admin name text field for input
        final TextField adminName = new TextField();
        adminName.setPromptText("Enter admin name.");
        GridPane.setConstraints(adminName, 1, 1, 1, 1, HPos.LEFT, VPos.CENTER);
        grid.getChildren().add(adminName);

        // make password label
        final Label passLabel = new Label();
        passLabel.setText("Password");
        GridPane.setConstraints(passLabel, 0, 2, 1, 1, HPos.RIGHT, VPos.CENTER);
        grid.getChildren().add(passLabel);

        // make password text field
        final PasswordField password = new PasswordField();
        password.setPromptText("Enter your password.");
        GridPane.setConstraints(password, 1, 2, 1, 1, HPos.LEFT, VPos.CENTER);
        grid.getChildren().add(password);

        // make button to submit login info
        final Button loginButton = new Button();
        loginButton.setText("Log In");
        loginButton.setStyle("-fx-font-size: 16px; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        GridPane.setConstraints(loginButton, 1, 3, 1, 1, HPos.RIGHT, VPos.CENTER);
        grid.getChildren().add(loginButton);

        // make button to go to dashboard
        final Button dashboardButton = new Button();
        dashboardButton.setText("Dashboard");
        dashboardButton.setStyle("-fx-font-size: 16px; -fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-weight: bold;");
        GridPane.setConstraints(dashboardButton, 1, 3, 1, 1, HPos.LEFT, VPos.CENTER);
        grid.getChildren().add(dashboardButton);

        // create an error label for login errors
        final Label error = new Label();
        GridPane.setConstraints(error, 1, 6);
        GridPane.setColumnSpan(error, 2);
        grid.getChildren().add(error);

        // create a welcome label for the dashboard scene
        final Label welcome = new Label();
        welcome.setText("Welcome to the dashboard!");
        welcome.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        GridPane.setConstraints(welcome, 0, 0, 3, 1); // set the welcome label to span three columns
        dashboardGrid.getChildren().add(welcome);

        // make logout button for dashboard page
        final Button logoutButton = new Button();
        logoutButton.setText("Logout");
        GridPane.setConstraints(logoutButton, 2, 5);
        dashboardGrid.getChildren().add(logoutButton);

        // set the grid background color to light gray
        grid.setStyle("-fx-background-color: #f5f5f5;");

        //when loginButton is pressed, this happens
        loginButton.setOnAction(event -> {
            // clear any leftover text in error
            error.setText("");

            if (adminName.getText().equals(admin.getUsername()) && password.getText().equals(admin.getPassword())) {
                // clear leftover admin name and password text
                adminName.clear();
                password.clear();

                // switch to dashboard scene
                primaryStage.setScene(dashboard);
                primaryStage.show();

            } else {
                // display error message for incorrect credentials
                error.setText("Incorrect credentials. Please try again.");
            }
        });

        //when dashboardButton is pressed, this happens
        dashboardButton.setOnAction(event -> {
            // clear leftover admin name and password text
            adminName.clear();
            password.clear();

            // switch to dashboard scene
            primaryStage.setScene(menuPage(url, user, passwordDB));
            primaryStage.show();
        });

        // when logoutButton is pressed, this happens
        logoutButton.setOnAction(event -> {
            // go back to the login page
            primaryStage.setScene(login);
            primaryStage.show();
        });

        return login;
    }

    public Scene menuPage(String url, String username, String pass) {
        AnchorPane anchor = new AnchorPane();
        GridPane grid = new GridPane();
        ScrollPane scroll = new ScrollPane();
        String getMenu = "SELECT item_id, item_name, item_price, category FROM menu ORDER BY category";
        try {

            Connection conn = DriverManager.getConnection(url+"/data", username, pass);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(getMenu);
            int offset = 1;
            String lastCat = "";
            while (rs.next()) {
                String cat = rs.getString("category");
                if (!lastCat.equals(cat) || offset == 1) {

                    Label category = new Label(cat);
                    grid.add(category, 1, offset);
                    offset++;
                }
                lastCat = cat;
                Label itemID = new Label("(" + rs.getString("item_id") + ") ");
                Label name = new Label(rs.getString("item_name"));
                Label item_price = new Label(rs.getString("item_price") + " ");
                Button add = new Button("Add");
                grid.add(itemID, 2, offset);
                grid.add(name, 3, offset);
                grid.add(item_price, 4, offset);
                grid.add(add, 5, offset);

                offset++;




            }

            scroll.setContent(grid);
            scroll.setPrefViewportHeight(400);
            scroll.setPrefViewportWidth(300);
            AnchorPane.setTopAnchor(grid, 120.0);
            AnchorPane.setLeftAnchor(grid, 10.0);
            AnchorPane.setRightAnchor(grid, 230.0);
            AnchorPane.setBottomAnchor(grid, 120.0);

            anchor.getChildren().add(scroll);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Scene j = new Scene(anchor);

        return j;
    }


}