package src;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//extends application for JavaFX
public class Main extends Application {
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

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost";
        //make sure your local server is on and username and password are the according to this below
        String user = "root";
        String password = "root1234";

        //create an instance for Database class
        Database database = null;

        try {
            database = new Database(url, user, password, menuItems, employees);
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
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        // make new grid (dashboard page)
        GridPane dashboardGrid = new GridPane();
        dashboardGrid.setPadding(new Insets(10, 10, 10, 10));
        dashboardGrid.setMinSize(100, 100);
        dashboardGrid.setVgap(5);
        dashboardGrid.setHgap(5);

        // make Log In label
        final Label loginLabel = new Label();
        loginLabel.setText("Log In");
        GridPane.setConstraints(loginLabel, 0, 0);
        GridPane.setColumnSpan(loginLabel, 2);
        grid.getChildren().add(loginLabel);

        // make admin name label
        final Label adminNameLabel = new Label();
        adminNameLabel.setText("Admin Name");
        GridPane.setConstraints(adminNameLabel, 1, 1);
        GridPane.setColumnSpan(adminNameLabel, 2);
        grid.getChildren().add(adminNameLabel);

        // make admin name text field for input
        final TextField adminName = new TextField();
        adminName.setPromptText("Enter admin name.");
        adminName.getText();
        GridPane.setConstraints(adminName, 1, 2);
        grid.getChildren().add(adminName);

        // make password label
        final Label passLabel = new Label();
        passLabel.setText("Password");
        GridPane.setConstraints(passLabel, 1, 3);
        GridPane.setColumnSpan(passLabel, 2);
        grid.getChildren().add(passLabel);

        // make password text field
        final TextField password = new TextField();
        password.setPromptText("Enter your password.");
        GridPane.setConstraints(password, 1, 4);
        grid.getChildren().add(password);
        password.getText();

        // make button to submit login info
        final Button loginButton = new Button();
        loginButton.setText("Log In");
        GridPane.setConstraints(loginButton, 1, 5);
        grid.getChildren().add(loginButton);

        // make button to go to dashboard
        final Button dashboardButton = new Button();
        dashboardButton.setText("Dashboard");
        GridPane.setConstraints(dashboardButton, 2, 5);
        grid.getChildren().add(dashboardButton);

        // create the scenes where the grids will appear
        Scene login = new Scene(grid);
        Scene dashboard = new Scene(dashboardGrid);

        // create an error label for login errors
        final Label error = new Label();
        GridPane.setConstraints(error, 1, 6);
        GridPane.setColumnSpan(error, 2);
        grid.getChildren().add(error);

        // create a welcome label for the dashboard scene
        final Label welcome = new Label();
        welcome.setText("Welcome to the dashboard!");
        GridPane.setConstraints(welcome, 0, 0);
        GridPane.setColumnSpan(welcome, 2);
        dashboardGrid.getChildren().add(welcome);

        // make view timecard button for dashboard page
//        final Button viewTimecardButton = new Button();
//        viewTimecardButton.setText("View Timecard");
//        GridPane.setConstraints(viewTimecardButton, 1, 1);
//        GridPane.setColumnSpan(viewTimecardButton, 2);
//        dashboardGrid.getChildren().add(viewTimecardButton);

        // make logout button for dashboard page
        final Button logoutButton = new Button();
        logoutButton.setText("Logout");
        GridPane.setConstraints(logoutButton, 2, 5);
        dashboardGrid.getChildren().add(logoutButton);

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
                error.setText("Incorrect credentials.");
            }
        });

        //when dashboardButton is pressed, this happens
        dashboardButton.setOnAction(event -> {
            // clear leftover admin name and password text
            adminName.clear();
            password.clear();

            // switch to dashboard scene
            primaryStage.setScene(dashboard);
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
}