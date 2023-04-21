package src;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//extends application for JavaFX
public class Main extends Application {
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

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost";
        //make sure your local server is on and username and password are the according to this below
        String user = "root";
        String password = "root1234";

        //create an instance for Database class
        Database database = null;

        try {
            database = new Database(url, user, password, menuItems, employees);
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

        Scene login = firstLogin(primaryStage);
        // show the initial login window
        primaryStage.setScene(login);
        primaryStage.show();


    }

    public Scene dashScene(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dashPage.fxml"));
        //scene.getStylesheets().add(getClass().getResource());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Dashboard");
        //String css = this.getClass().getResource("dashStyle.css").toExternalForm();
        //scene.getStylesheets().add(css);
        primaryStage.setScene(scene);
        primaryStage.show();
        return scene;
    }

    /*
    creates the login page for the first login required of the user
     */
    public Scene firstLogin(Stage primaryStage) {
        //create a new user and add to the User object
        User users = new User("a", "1");
        User userB = new User("b", "2");

        User admin = new User("admin", "admin123");

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

        //make view timecard button for admin page
        final Button viewTimecardButton = new Button();
        viewTimecardButton.setText("View Timecard");
        GridPane.setConstraints(viewTimecardButton, 1, 1);
        GridPane.setColumnSpan(viewTimecardButton, 2);

        //create a new grid for the admin page
        GridPane adminGrid = new GridPane();
        adminGrid.setPadding(new Insets(10, 10, 10, 10));
        adminGrid.setMinSize(100, 100);
        adminGrid.setVgap(5);
        adminGrid.setHgap(5);

        //add the view timecard button to the admin grid
        adminGrid.getChildren().add(viewTimecardButton);

        //create a new scene for the admin page
        Scene adminScene = new Scene(adminGrid);

        //when loginButton is pressed, this happens
        loginButton.setOnAction(event -> {
            // clear any leftover text in error
            error.setText("");

            if (name.getText().equals(users.getUsername()) && password.getText().equals(users.getPassword())) {
                // clear leftover name and password text
                name.clear();
                password.clear();

                // switch to success scene for user A
                primaryStage.setScene(success);
                primaryStage.show();

            } else if (name.getText().equals(userB.getUsername()) && password.getText().equals(userB.getPassword())) {
                // clear leftover name and password text
                name.clear();
                password.clear();

                // switch to success scene for user B
                primaryStage.setScene(success);
                primaryStage.show();

            } else if (name.getText().equals(admin.getUsername()) && password.getText().equals(admin.getPassword())) {
                // clear leftover name and password text
                name.clear();
                password.clear();

                // switch to admin scene
                primaryStage.setScene(adminScene);
                primaryStage.show();

            } else {
                // display error message for incorrect credentials
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
                Timecard timecard = new Timecard(currentTime, null);
                // get the user object and add the new timecard to their list of timecards
                users.getTimecards().add(timecard);
                userB.getTimecards().add(timecard);
                //display message
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Clock In");
                alert.setHeaderText(null);
                alert.setContentText("You have clocked in at " + currentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss a")));
                alert.showAndWait();
            });

            //when clockOutButton is pressed, show the alert message
            clockOutButton.setOnAction(event1 -> {
                // get the most recent timecard
                List<Timecard> timecards = users.getTimecards();
                List<Timecard> timecards2 = userB.getTimecards();
                Timecard mostRecentTimecard = timecards.get(timecards.size() - 1);
                Timecard mostRecentTimecard2 = timecards2.get(timecards2.size() - 1);

                // update the clockOutTime field with the current time
                mostRecentTimecard.setClockOutTime(LocalDateTime.now());
                mostRecentTimecard2.setClockOutTime(LocalDateTime.now());

                //display message
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Clock Out");
                alert.setHeaderText(null);
                alert.setContentText("You have clocked out at " + mostRecentTimecard.getClockOutTime().format(DateTimeFormatter.ofPattern("hh:mm:ss a")));
                //set onHidden event handler to go back to log in scene and reset name and password fields
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

        //when view Time card Button is pressed, show the alert message and when the user click ok, back to login page
        viewTimecardButton.setOnAction(event -> {
            User selectedUser = null;

            if (users.getTimecards().isEmpty() && userB.getTimecards().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("View Timecard");
                alert.setHeaderText(null);
                alert.setContentText("There are no timecards to view.");
                alert.showAndWait();
                return;
            } else if (users.getTimecards().isEmpty()) {
                selectedUser = userB;
            } else if (userB.getTimecards().isEmpty()) {
                selectedUser = users;
            } else {
                // create a dialog to select the user
                ChoiceDialog<User> dialog = new ChoiceDialog<>(null, users, userB);
                dialog.setTitle("View Timecard");
                dialog.setHeaderText(null);
                dialog.setContentText("Select a user:");

                // filter the list of users to only show those who have timecards
                dialog.getItems().removeIf(user -> user.getTimecards().isEmpty());

                Optional<User> result = dialog.showAndWait();

                if (result.isPresent()) {
                    selectedUser = result.get();
                } else {
                    return;
                }
            }

            List<Timecard> timecards = selectedUser.getTimecards();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("View Timecard");
            alert.setHeaderText(null);
            alert.setContentText("Timecard information for " + selectedUser.getUsername() + ":\n\n");

            // add the timecard information to the alert message
            for (Timecard timecard : timecards) {
                String clockInTime = timecard.getClockInTime().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a"));
                String clockOutTime = timecard.getClockOutTime() == null ? "N/A" : timecard.getClockOutTime().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a"));
                alert.setContentText(alert.getContentText() + "Clock In: " + clockInTime + "\nClock Out: " + clockOutTime + "\n\n");
            }

            alert.showAndWait();
        });




        return login;
    }

}