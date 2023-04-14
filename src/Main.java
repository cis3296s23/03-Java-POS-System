package src;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//extends application for JavaFX
public class Main extends Application {
    private static HashMap<String, LocalTime> empClockIns = new HashMap<>();
    private static HashMap<String, LocalTime> empClockOuts = new HashMap<>();
    public static void main(String[] args) {
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

        //change the username and password for easier test
        String rest1Name = "a";
        String pass1 = "1";
        String adminName = "admin";
        String adminPass = "admin123";

        //make new grid where labels, fields, buttons, etc. are placed (login page)
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        //make new grid (success page)
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setMinSize(100,100);
        grid2.setVgap(5);
        grid2.setHgap(5);

        //make Log In label
        final Label loginLabel = new Label();
        loginLabel.setText("Log In");
        GridPane.setConstraints(loginLabel, 0, 0);
        GridPane.setColumnSpan(loginLabel, 2);
        grid.getChildren().add(loginLabel);

        //make username label
        final Label userLabel = new Label();
        userLabel.setText("Username");
        GridPane.setConstraints(userLabel, 1, 1);
        GridPane.setColumnSpan(userLabel, 2);
        grid.getChildren().add(userLabel);

        //make username text field for input
        final TextField name = new TextField();
        name.setPromptText("Enter your username.");
        name.getText();
        GridPane.setConstraints(name, 1, 2);
        grid.getChildren().add(name);

        //make password label
        final Label passLabel = new Label();
        passLabel.setText("Password");
        GridPane.setConstraints(passLabel, 1, 3);
        GridPane.setColumnSpan(passLabel, 2);
        grid.getChildren().add(passLabel);

        //make password text field
        final TextField password = new TextField();
        password.setPromptText("Enter your password.");
        GridPane.setConstraints(password, 1, 4);
        grid.getChildren().add(password);
        password.getText();

        //make button to submit login info
        final Button loginButton = new Button();
        loginButton.setText("Log In");
        GridPane.setConstraints(loginButton, 1, 5);
        grid.getChildren().add(loginButton);

        //create the scenes where the grids will appear
        Scene login = new Scene(grid);
        Scene success = new Scene(grid2);

        //create an error label for login errors
        final Label error = new Label();
        GridPane.setConstraints(error, 1, 6);
        GridPane.setColumnSpan(error, 2);
        grid.getChildren().add(error);

        //create a welcome label for the success scene
        final Label welcome = new Label();
        welcome.setText("Welcome! You've successfully logged in.");
        GridPane.setConstraints(welcome, 0, 3);
        GridPane.setColumnSpan(welcome, 2);
        grid2.getChildren().add(welcome);

        //create a back button
        final Button back = new Button();
        back.setText("<-");
        GridPane.setConstraints(back, 0, 5);
        grid2.getChildren().add(back);

        // create a clock-in button
        final Button clockIn = new Button();
        clockIn.setText("Clock In");
        GridPane.setConstraints(clockIn, 0, 4);
        grid2.getChildren().add(clockIn);

        // create a clock-out button
        final Button clockOut = new Button();
        clockOut.setText("Clock Out");
        GridPane.setConstraints(clockOut, 1, 4);
        grid2.getChildren().add(clockOut);

        //when loginButton is pressed, this happens
        loginButton.setOnAction(event -> {
            // clear any leftover text in error
            error.setText("");
            if (name.getText().equals(rest1Name) && password.getText().equals(pass1)) {
                // clear leftover name and password text
                name.clear();
                password.clear();
                // switch to success scene
                primaryStage.setScene(success);
                primaryStage.show();
                // run the rest of the program
                // restaurant(rest1Name, pass1);

            } else {
                error.setText("Incorrect credentials.");
            }
        });

        // handler for clock-in button
        clockIn.setOnAction(event -> {
            // get the current time
            LocalTime now = LocalTime.now();
            // get the employee's username
            String username = name.getText();
            // add the current time to the empClockIns HashMap for this employee
            empClockIns.put(username, now);
            // display a message to the user that they have clocked in
            welcome.setText("You have clocked in at " + now.toString());
        });

        // handler for clock-out button
        clockOut.setOnAction(event -> {
            // get the current time
            LocalTime now = LocalTime.now();
            // get the employee's username
            String username = name.getText();
            // add the current time to the empClockOuts HashMap for this employee
            empClockOuts.put(username, now);
            // display a message to the user that they have clocked out
            welcome.setText("You have clocked out at " + now.toString());
            primaryStage.setScene(login);
            primaryStage.show();
        });

        // handler for back button on success scene (back should have a more specific name)
        back.setOnAction(event -> {
            // show the login scene
            primaryStage.setScene(login);
            primaryStage.show();
        });

        return login;
    }

}

