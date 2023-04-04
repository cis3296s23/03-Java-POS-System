import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseTest {
    public static void main(String[] args) {
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
            sql = "CREATE TABLE customers " +
                    "(id INT PRIMARY KEY, " +
                    "name VARCHAR(255), " +
                    "email VARCHAR(255))";
            st.executeUpdate(sql);
            System.out.println("Table created successfully...");

            // Insert data into the table
            System.out.println("Inserting data into table...");
            sql = "INSERT INTO customers (id, name, email) " +
                    "VALUES (1, 'John Smith', 'john@example.com')";
            st.executeUpdate(sql);
            sql = "INSERT INTO customers (id, name, email) " +
                    "VALUES (2, 'Jane Doe', 'jane@example.com')";
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
}
