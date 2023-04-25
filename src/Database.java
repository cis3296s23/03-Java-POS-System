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

}
