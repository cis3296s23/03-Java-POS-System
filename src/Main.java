package src;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
        GridPane successGrid = new GridPane();
        successGrid.setPadding(new Insets(10, 10, 10, 10));
        successGrid.setMinSize(100, 100);
        successGrid.setVgap(5);
        successGrid.setHgap(5);

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
        Scene success = new Scene(successGrid);

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
        successGrid.getChildren().add(welcome);

        //make continue button for success page
        final Button continueButton = new Button();
        continueButton.setText("Continue");
        GridPane.setConstraints(continueButton, 1, 4);
        successGrid.getChildren().add(continueButton);

        //create a back button
        final Button back = new Button();
        back.setText("<-");
        GridPane.setConstraints(back, 0, 5);
        successGrid.getChildren().add(back);

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

            }else {
                error.setText("Incorrect credentials.");
            }
        });

        //when continueButton is pressed, this happens
        continueButton.setOnAction(event -> {
            //create a new grid for the clock-in/out page
            GridPane clockGrid = new GridPane();
            clockGrid.setPadding(new Insets(10, 10, 10, 10));
            clockGrid.setMinSize(100, 100);
            clockGrid.setVgap(5);
            clockGrid.setHgap(5);

            //make clock-in button
            final Button clockInButton = new Button();
            clockInButton.setText("Clock In");
            GridPane.setConstraints(clockInButton, 1, 1);
            clockGrid.getChildren().add(clockInButton);

            //make clock-out button
            final Button clockOutButton = new Button();
            clockOutButton.setText("Clock Out");
            GridPane.setConstraints(clockOutButton, 2, 1);
            clockGrid.getChildren().add(clockOutButton);

            //make back button to return to the success page
            final Button clockBackButton = new Button();
            clockBackButton.setText("Back");
            GridPane.setConstraints(clockBackButton, 0, 2);
            clockGrid.getChildren().add(clockBackButton);

            //create a new scene for the clock-in/out page
            Scene clockScene = new Scene(clockGrid);

            //when clockInButton is pressed, this happens
            clockInButton.setOnAction(event1 -> {
                //get current time
                LocalDateTime currentTime = LocalDateTime.now();
                //display message
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Clock In");
                alert.setHeaderText(null);
                alert.setContentText("You have clocked in at " + currentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss a")));
                alert.showAndWait();
            });

            //when clockOutButton is pressed, show the alert message
            clockOutButton.setOnAction(event1 -> {
                //get current time
                LocalDateTime currentTime = LocalDateTime.now();
                //display message
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Clock Out");
                alert.setHeaderText(null);
                alert.setContentText("You have clocked out at " + currentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss a")));
                //set onHidden event handler to go back to login scene and reset name and password fields
                alert.setOnHidden(e -> {
                    name.clear();
                    password.clear();
                    primaryStage.setScene(login);
                    primaryStage.show();
                });
                alert.showAndWait();
            });

            //when clockBackButton is pressed, this happens
            clockBackButton.setOnAction(event1 -> {
                // go back to the success page
                primaryStage.setScene(success);
                primaryStage.show();
            });

            // switch to the clock-in/out scene
            primaryStage.setScene(clockScene);
            primaryStage.show();
        });


        // handler for back button on success scene (back should have a more specific name)
        back.setOnAction(event -> {
            primaryStage.setScene(login);
            primaryStage.show();
        });

        return login;
    }

}

