package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {
    private Connection connection;
    private String[][] menuItems;
    private String[][] employees;
    private Statement st;
    private String sql;

    public Database(String url, String user, String password, String[][] menu, String[][] emp) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        this.menuItems = menu;
        this.employees = emp;
    }

    public void createDatabase() throws SQLException {
        st = connection.createStatement();
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
        }
        System.out.println("\nGOODBYE");
        st.close();
    }

    public void close() throws SQLException {
        connection.close();
    }
}
