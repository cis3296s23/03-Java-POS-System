/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.system;

import javafx.application.Application;
import static javafx.application.Application.launch;
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

/**
 *
 * @author Michael
 */
public class POSSystem extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Login");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text login = new Text("Account Login");
        login.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 18));
        grid.add(login, 0, 1);
        Label user = new Label("Username");
        TextField userInput = new TextField();
        grid.add(user, 0, 2);
        grid.add(userInput, 1, 2);
        
        Label pass = new Label("Password");
        TextField passInput = new TextField();
        grid.add(pass, 0, 3);
        grid.add(passInput, 1, 3);
        
        Button loginB = new Button("Login");
        grid.add(loginB, 0, 4);
        Scene scene = new Scene(grid, 300, 250);
        
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}