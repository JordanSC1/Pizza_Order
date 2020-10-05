/*
    PizzeriaController.java
    Author: Jordan graham
    Date: March 25th, 2020

    Description
    PizzeriaController class is the controller class for FXMLPizzeria.fxml and 
    controls the reactions to the user interactions with the application
    */
package grahajor;

// imports
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author jrgra
 */
public class PizzeriaController implements Initializable {
    
    // properties from the fxml file
    @FXML
    private ToggleGroup sizes;
    @FXML
    private ToggleGroup drinks;
    @FXML
    private MenuItem exit;
    @FXML
    private TextField numPizzas;
    @FXML
    private TextField numDrinks;
    @FXML
    private TextArea receiptField;
    @FXML
    private Button btnOK;
    @FXML
    private Button btnCancel;
    @FXML
    private CheckBox toppingsCheese;
    @FXML
    private CheckBox toppingsPepperoni;
    @FXML
    private CheckBox toppingsMushrooms;
    @FXML
    private CheckBox toppingsOlives;

    // initialize a new PizzaOrder
    private PizzaOrder order = new PizzaOrder();
    // tax rate is a constant
    private final double TAX_RATE = 0.13;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // when the user activates the cancel button, clearAll is called
        btnCancel.setOnAction(e -> clearAll(e));
        // when the user activates the OK button, submitOrder is called
        btnOK.setOnAction(e -> submitOrder(e));
        // when the user activates the Exit option, the program closes
        exit.setOnAction(e -> {
            System.exit(0);
        });
    }    
    
    /**
     * clearAll is a method that clears all the data entry fields in the fxml
     * file
     */
    @FXML
    public void clearAll(Event e) {
        numPizzas.clear();
        numDrinks.clear();
        receiptField.clear();
        // for the checkboxes, if they are selected, they are fired and no 
        // longer selected
        if (toppingsCheese.isSelected()) {
            toppingsCheese.fire();
        }
        if (toppingsPepperoni.isSelected()) {
            toppingsPepperoni.fire();
        }
        if (toppingsMushrooms.isSelected()) {
            toppingsMushrooms.fire();
        }
        if (toppingsOlives.isSelected()) {
            toppingsOlives.fire();
        }
        // for the toggle groups, it sets the selected toggle to null
        drinks.selectToggle(null);
        sizes.selectToggle(null);
        // order becomes a new pizza order 
        order = new PizzaOrder();
    }
    
    /**
     * submitOrder takes all the information provided by the user and places the
     * order, then displays a receipt for the user.
     */
    @FXML
    public void submitOrder(Event e) {
        // creates new radio buttons, which are used to hold the information 
        // of the selected toggles for each toggle 
        RadioButton drink;
        RadioButton selectedSize;
        
        // try catch to check for exceptions being thrown
        try {
            // checks if the user did not enter a number for drinks or
            // pizzas
            if (numDrinks.getText().isEmpty() 
                    && numPizzas.getText().isEmpty()) {
                // throws an exception prompting them to fill in at least one
                throw new IllegalArgumentException("You must select at least" 
                        + " one pizza or drink");
            }
            
            // checks to see if the user selected a drink
            if (drinks.getSelectedToggle() != null) {
                // assigns the selected drink to the drink toggle
                drink = (RadioButton) drinks.getSelectedToggle();
                // sets order.drinks to the text of the selected toggle
                // the text is converted to uppercase and  the space in 
                // "CHOCOLATE MILK" is replaced with an "_"
                order.drinks = Drinks.valueOf(drink.getText().replaceAll(" "
                        , "_").toUpperCase());
                // sets the number of drinks to the text of the numDrinks text
                // field
                order.setNumDrinks(Integer.parseInt(numDrinks.getText()));
            }
            
            
            // checks to see if the user selected a size
            if (sizes.getSelectedToggle() != null) {
                // assigns the selected size to the selectedSize toggle
                selectedSize = (RadioButton) sizes.getSelectedToggle();
                // sets order.size to the text of the selected toggle
                // the text is converted to uppercase
                order.size = PizzaSize.valueOf(selectedSize.getText()
                        .toUpperCase());
                // sets the number of pizzas to the text of the numPizzas text
                // field
                order.setNumPizzas(Integer.parseInt(numPizzas.getText()));
                // checks if any of the checkboxes are selected, if so
                // the equivalent enum constant is added to toppings list
                if (toppingsCheese.isSelected()) {
                    order.setToppings(Toppings.CHEESE);
                }
                if (toppingsPepperoni.isSelected()) {
                    order.setToppings(Toppings.PEPPERONI);
                }
                if (toppingsMushrooms.isSelected()) {
                    order.setToppings(Toppings.MUSHROOMS);
                }
                if (toppingsOlives.isSelected()) {
                    order.setToppings(Toppings.OLIVES);
                }
                
                int age = Integer.parseInt(numPizzas.getText());
                System.out.printf("Age: %d", age);
            }
            
            // displays the receipt in the receipField
            receiptField.setText(String.format(order.toString() 
                    + "\n%-9s%21.2f\n%-9s%21.2f", "HST:", order.getSubtotal() 
                    * TAX_RATE, "Total:", order.getSubtotal() 
                    * (1 + TAX_RATE)));
            // incase the user enters a non numerical value
        } catch (NumberFormatException eh) {
            System.out.println("invalid input");
            receiptField.setText("Error: You must enter number!");
            // catches any logic errors with the user's input
        } catch (IllegalArgumentException eh) {
            receiptField.setText(eh.getMessage());
        }
    }
}
