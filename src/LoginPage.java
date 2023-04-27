package src;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPage {

    LoginPage() {

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

            MenuPage menu = new MenuPage();
            // switch to dashboard scene
            menu.display(primaryStage);
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
