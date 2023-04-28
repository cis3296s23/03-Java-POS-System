package src;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * stores database information
 */
public class Database {
    private Connection connection;
    private String[][] menuItems;
    private String[][] employees;
    private Statement st;
    private String sql;

    /**
     * connects to the database
     * @param firstLaunch user returns whether the database schema exists or not, set to true if not sure
     * @return connection to the database
     */
    public static Connection connectToDB(boolean firstLaunch){
        try {
            String url;
            if (firstLaunch)
                url = "jdbc:mysql://localhost";
             else
            url = "jdbc:mysql://localhost/data";
            //make sure your local server is on and username and password are the according to this below
            String user = "root";
            String password = "root1234";

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection(url, user, password); // LINK YOUR DATABASE
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
    * creates and populates necessary tables for the program using a provided connection
    * @param conn uses this connection to get to the database
     */
    public void createInitialTables(Connection conn) {
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
        try {
            st = conn.createStatement();
            sql = "CREATE DATABASE IF NOT EXISTS data";
            st.executeUpdate(sql);
            sql = "USE data";
            st.executeUpdate(sql);
            // Create a table
            System.out.println("\nCreating table for menu...");
            sql = "CREATE TABLE menu" +
                    "(item_id INT PRIMARY KEY, " +
                    "item_name VARCHAR(50), " +
                    "category VARCHAR(50), " +
                    "item_price DECIMAL(10,2))";
            st.executeUpdate(sql);
            System.out.println("Table created successfully...");

            // Insert menu items into the menu table
            for (int i = 0; i < menuItems.length; i++) {
                String item_id = menuItems[i][0];
                String item_name = menuItems[i][1];
                String category = menuItems[i][2];
                String item_price = menuItems[i][3];
                sql = "INSERT INTO menu (item_id, item_name, category, item_price) VALUES ('" + item_id + "', '" + item_name +
                        "', '" + category + "', '" + item_price + "')";
                st.executeUpdate(sql); // execute the insert statement
            }
            // Create a table
            System.out.println("\nCreating table for employees...");
            sql = "CREATE TABLE employees" +
                    "(item_id INT PRIMARY KEY, " +
                    "full_name VARCHAR(255), " +
                    "email VARCHAR(255), " +
                    "salary DECIMAL(10,2), "+
                    "position VARCHAR(255))";

            st.executeUpdate(sql);
            System.out.println("Table created successfully...");

            // Insert menu items into the menu table
            for (int i = 0; i < employees.length; i++) {
                String item_id = employees[i][0];
                String full_name = employees[i][1];
                String email = employees[i][2];
                String salary = employees[i][3];
                String position = employees[i][4];
                sql = "INSERT INTO employees (item_id, full_name, email, salary, position) VALUES ('" + item_id + "', '" + full_name +
                        "', '" + email + "', '" + salary + "', '" + position + "')";
                st.executeUpdate(sql); // execute the insert statement
                st.close();
            }

        } catch (SQLException e) {

        }
    }

    /**
     * closes connection
     */
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
