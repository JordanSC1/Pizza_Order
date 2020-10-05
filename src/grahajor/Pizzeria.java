/*
    Name:  Jordan Graham
    Assignment:  A4_JordanGraham
    Program: Pizzeria.java
    Date:  March 25th, 2020
    
    Description:
    An app for a pizzeria which allows the user to create an order and view the
    receipt for said order, uses javafx to create an fxml file representing the
    app
*/

package grahajor;

// imports
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_CASPIAN;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jrgra
 */
public class Pizzeria extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Method to load the FXML file and start the application
     * 
     * @param stage - the stage which will show the FXML file
     * @throws Exception - i don't know what to say here
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPizzeria.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Assignment 4");
        Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
        stage.setScene(scene);
        stage.show();
    }

}
