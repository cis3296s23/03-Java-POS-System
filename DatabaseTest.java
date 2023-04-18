import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice:");
        System.out.println("1. Create database");
        System.out.println("2. Access data from existing database");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                createDatabase();
                break;
            case 2:
                accessData();
                break;
            default:
                System.out.println("Invalid choice");
        }

    }

    public static void createDatabase() {

        Connection conn = null;
        Statement st = null;

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/";
        String user = "root";
        String password = "root1234";

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database.....");
            // Open a connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Creating database....");
            // Execute a query
            st = conn.createStatement();
            String sql = "CREATE DATABASE data";
            st.executeUpdate(sql);
            System.out.println("Database Created Successfully!");
            // Extract data from result set
            // Select the new database
            sql = "USE data";
            st.executeUpdate(sql);

            // Create a table
            System.out.println("Creating table...");
            sql = "CREATE TABLE employees " +
                    "(id INT PRIMARY KEY, " +
                    "name VARCHAR(255), " +
                    "email VARCHAR(255), " +
                    "salary DECIMAL(10,2), " +
                    "position VARCHAR(255))";
            st.executeUpdate(sql);
            System.out.println("Table created successfully...");

            // Insert data into the table
            System.out.println("Inserting data into table...");
            sql = "INSERT INTO employees (id, name, email, salary, position) " +
                    "VALUES (1, 'John Smith', 'john@example.com', '15.50', 'cashier')";
            st.executeUpdate(sql);
            sql = "INSERT INTO employees (id, name, email, salary, position) " +
                    "VALUES (2, 'Jane Doe', 'jane@example.com', '18.00', 'chef')";
            st.executeUpdate(sql);
            sql = "INSERT INTO employees (id, name, email, salary, position) " +
                    "VALUES (3, 'Ricky K', 'ricky@example.com', '20.00', 'headchef')";
            st.executeUpdate(sql);
            System.out.println("Data inserted successfully...");

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (st != null) st.close();
            } catch (SQLException e1) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e2){
                e2.printStackTrace();
            }
        }
        System.out.println("GoodBye");

    }

    public static void accessData() {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/data";
        String user = "root";
        String password = "root1234";

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(url, user, password);

            // Execute a query
            st = conn.createStatement();
            String sql = "SELECT id, name, email, salary, position FROM employees";
            rs = st.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                double salary = rs.getDouble("salary");
                String position = rs.getString("position");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Name: " + name);
                System.out.print(", Email: " + email);
                System.out.print(", Salary: " + salary);
                System.out.println(", Position: " + position);
            }
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
            } catch (SQLException e1) {
            }
            try {
                if (st != null) st.close();
            } catch (SQLException e2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}// end main
