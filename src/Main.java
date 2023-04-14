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
    Runs the rest of the program for now
    @param They don't do anything right now, but they're here just in case
     */
//    public void restaurant(String rest1Name, String pass1) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("\n******LOGIN SUCCESSFUL*****\n");
//        System.out.println("WELCOME TO DAVE'S BURGER");
//        System.out.println("Enter Username: ");
//        String user = scanner.nextLine();
//        System.out.println("Enter Password: ");
//        String pass = scanner.nextLine();
//
//        if (user.equals("admin") && pass.equals("admin123")) {
//            System.out.println("1. View Sale Report");
//            System.out.println("2. Take Order");
//            System.out.println("3. View Timecards");
//            System.out.println("4. Inventory");
//            System.out.println("Please enter your choice");
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    break;
//                case 2:
//                    System.out.println("***********CREATE ORDER***********");
//                    System.out.println("Enter customer name: ");
//                    String customerName = scanner.nextLine();
//                    System.out.println("Enter order details: ");
//                    String items = scanner.nextLine();
//                    System.out.println("Enter total price: ");
//                    double totalPrice = scanner.nextDouble();
//                    scanner.nextLine();
//                    System.out.println("Enter payment method: ");
//                    String paymentMethod = scanner.nextLine();
//                    Order order = new Order(customerName, Collections.singletonList(items), totalPrice, paymentMethod);
//                    System.out.println("Order created successfully!");
//                    System.out.println("***********CREATE ORDER***********");
//                    break;
//                case 3:
//                    System.out.println("***********TIMECARDS***********");
//                    for (String empId : empClockIns.keySet()) {
//                        System.out.print("Employee " + empId + ":\nClock in time: " + empClockIns.get(empId));
//                        if (empClockOuts.containsKey(empId)) {
//                            System.out.print("\nClock out time: " + empClockOuts.get(empId));
//                            Duration totalHours = Duration.between(empClockIns.get(empId), empClockOuts.get(empId));
//                            long hours = totalHours.toHours();
//                            long minutes = totalHours.toMinutes() % 60;
//                            System.out.println("\nTotal work hours: " + hours + " hours and " + minutes + " minutes.");
//                        } else {
//                            System.out.println("\nStatus: On shift.");
//                        }
//                    }
//                    break;
//                case 4:
//                    HashMap<String, Integer> inventory = new HashMap<>();
//                    inventory.put("Beef Burger", 50);
//                    inventory.put("Cheeseburger", 75);
//                    inventory.put("Hamburger", 100);
//                    inventory.put("French Fries", 200);
//                    inventory.put("Soft Drink", 300);
//                    inventory.put("Milkshake", 100);
//                    System.out.println("Current Inventory:");
//                    for (String item : inventory.keySet()) {
//                        System.out.println(item + ": " + inventory.get(item));
//                    }
//                    break;
//                case 0:
//                    break;
//                default:
//                    System.out.println("Invalid choice!");
//                    break;
//            }
//        } else {
//            boolean continueWorking = true;
//            while (continueWorking) {
//                System.out.println("1. Clock-in to start working");
//                System.out.println("2. Create Order");
//                System.out.println("3. View Menu");
//                System.out.println("4. Log Out");
//                System.out.println("Enter your selection: ");
//                int choice = scanner.nextInt();
//                scanner.nextLine();
//
//                switch (choice) {
//                    case 1:
//                        System.out.println("***********CLOCK-IN***********");
//                        System.out.println("Please enter your 4 digits employee number: ");
//                        String empInfo = scanner.nextLine();
//                        System.out.println("1. Clock-in to start working");
//                        System.out.println("2. Clock-out to finish working");
//                        System.out.println("Enter your selection: ");
//                        int choice2 = scanner.nextInt();
//                        if (choice2 == 1) {
//                            empClockIns.put(empInfo, LocalTime.now());
//                            System.out.println("You have successfully clocked-in.");
//                        } else if (choice2 == 2) {
//                            empClockOuts.put(empInfo, LocalTime.now());
//                            System.out.println("You have successfully clocked-out.");
//                        }
//                        if (empClockIns.containsKey(empInfo)) {
//                            LocalTime clockInTime = empClockIns.get(empInfo);
//                            LocalTime clockOutTime = empClockOuts.get(empInfo);
//                            if (clockOutTime == null) {
//                                Duration totalHours = Duration.between(clockInTime, LocalTime.now());
//                                long hours = totalHours.toHours();
//                                long minutes = totalHours.toMinutes() % 60;
//                                System.out.println("You have worked " + hours + " hours and " + minutes + " minutes today.");
//                                System.out.println("You clocked in at " + clockInTime + ".");
//                            } else {
//                                Duration totalHours = Duration.between(clockInTime, clockOutTime);
//                                long hours = totalHours.toHours();
//                                long minutes = totalHours.toMinutes() % 60;
//                                System.out.println("You worked " + hours + " hours and " + minutes + " minutes on your last shift.");
//                                System.out.println("You clocked in at " + clockInTime + " and clocked out at " + clockOutTime + ".");
//                            }
//                        } else {
//                            System.out.println("You have not clocked in today.");
//                        }
//                        break;
//                    case 2:
//                        System.out.println("***********CREATE ORDER***********");
//                        System.out.println("Enter customer name: ");
//                        String customerName = scanner.nextLine();
//                        System.out.println("Enter order details: ");
//                        String items = scanner.nextLine();
//                        System.out.println("Enter total price: ");
//                        double totalPrice = scanner.nextDouble();
//                        scanner.nextLine();
//                        System.out.println("Enter payment method: ");
//                        String paymentMethod = scanner.nextLine();
//                        Order order = new Order(customerName, Collections.singletonList(items), totalPrice, paymentMethod);
//                        System.out.println("Order created successfully!");
//                        System.out.println("***********CREATE ORDER***********");
//                        break;
//                    case 3:
//                        System.out.println("***********MENU***********");
//                        System.out.println("1. Beef Burger - $11.99");
//                        System.out.println("2. Cheeseburger - $9.99");
//                        System.out.println("3. Hamburger - $8.99");
//                        System.out.println("4. French Fries - $4.99");
//                        System.out.println("5. Soft Drink - $1.99");
//                        System.out.println("6. Milkshake - $5.99");
//                        System.out.println("***********MENU***********");
//                        break;
//                    case 4:
//                        continueWorking = false;
//                        break;
//                    case 0:
//                        break;
//                    default:
//                        System.out.println("Invalid choice!");
//                        break;
//                }
//            }
//        }
//    }
    /*
    creates the login page for the first login required of the user
     */
    public Scene firstLogin(Stage primaryStage) {

        //change the username and password for easier test
        String rest1Name = "a";
        String pass1 = "1";
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
//                restaurant(rest1Name, pass1);

            } else {
                error.setText("Incorrect credentials.");
            }
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

