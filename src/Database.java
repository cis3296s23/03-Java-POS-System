package src;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Database {
    private Connection connection;
    private String[][] menuItems;
    private String[][] employees;
    private Statement st;
    private String sql;

/*    public Database(String url, String user, String password, String[][] menu, String[][] emp) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        this.menuItems = menu;
        this.employees = emp;
    }*/

    public static Connection connectToDB(){
        try {
            String url = "jdbc:mysql://localhost/data";
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

      /*  st = connection.createStatement();
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

        //Create a table
        System.out.println("\nCreating table for orders...");
        sql = "CREATE TABLE orders " +
                "(order_id INT NOT NULL AUTO_INCREMENT, " +
                " order_date DATE, " +
                " customer_name VARCHAR(255), " +
                "order_total DOUBLE(10,2), " +
                " PRIMARY KEY ( order_id ))";

        st.executeUpdate(sql);
        System.out.println("Table created successfully...");

        sql = "INSERT INTO orders (order_date, customer_name, order_total) VALUES (?, ?, ?)";

        PreparedStatement pstmt = connection.prepareStatement(sql);

            // Get the current date and format it
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
            String formattedDate = currentDate.format(formatter);

            // Set the values of the parameters in the prepared statement
            pstmt.setString(1, formattedDate);
            pstmt.setString(2, "John Doe");
            pstmt.setDouble(3, 150.00);
            pstmt.addBatch(); // Add the first set of values to the batch

            pstmt.setString(1, formattedDate);
            pstmt.setString(2, "Jane Smith");
            pstmt.setDouble(3, 200.00);
            pstmt.addBatch(); // Add the second set of values to the batch

            pstmt.setString(1, formattedDate);
            pstmt.setString(2, "Bob Johnson");
            pstmt.setDouble(3, 75.00);
            pstmt.addBatch(); // Add the third set of values to the batch

            pstmt.executeBatch(); // Execute the batch
*//*        // Create table for order items
        System.out.println("\nCreating table for order items...");
        sql = "CREATE TABLE order_items " +
                "(item_id INT NOT NULL AUTO_INCREMENT, " +
                " order_id INT, " +
                " item_name VARCHAR(255), " +
                " quantity INT, " +
                " price DOUBLE(10,2), " +
                " PRIMARY KEY ( item_id ), " +
                " FOREIGN KEY ( order_id ) REFERENCES orders(order_id))";
        st.executeUpdate(sql);
        System.out.println("Table created successfully...");

        sql = "INSERT INTO order_items (order_id, item_name, quantity, price) VALUES " +
                "(LAST_INSERT_ID(), 'Item 1', 2, 25.00), " +
                "(LAST_INSERT_ID(), 'Item 2', 1, 50.00), " +
                "(LAST_INSERT_ID(), 'Item 1', 3, 30.00), " +
                "(LAST_INSERT_ID(), 'Item 2', 2, 50.00), " +
                "(LAST_INSERT_ID(), 'Item 3', 1, 70.00), " +
                "(LAST_INSERT_ID(), 'Item 1', 1, 75.00);";
        st.executeUpdate(sql);*//*
        System.out.println("\nGOODBYE");
        st.close();*/
}
