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
    static String passwordDB = "root1234";
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
        LoginPage loginPage = new LoginPage();
        Scene login = loginPage.firstLogin(primaryStage);
        // show the initial login window
        primaryStage.setScene(login);
        primaryStage.show();
    }


}