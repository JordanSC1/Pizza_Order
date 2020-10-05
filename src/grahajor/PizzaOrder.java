/*
    PizzaOrder.java
    Author: Jordan graham
    Date: March 25th, 2020

    Description
    PizzaOrder class represents a pizza order, you can order as many pizzas as
    you want of the size of your choice with a selection of toppings and drinks
    this class can calculate the subtotal of the order and create part of the
    receipt
    */

package grahajor;

import java.util.ArrayList;

/**
 *
 * @author jrgra
 */
public class PizzaOrder {
    public PizzaSize size;
    private ArrayList<Toppings> toppings;
    public Drinks drinks;
    private int numPizzas;
    private int numDrinks;
    
    /**
     * empty constructor which makes a new PizzaOrder.
     *
     */
    public PizzaOrder() {
        toppings = new ArrayList<>();
    }

    /**
     * Method which adds a selected topping to the list of toppings
     * 
     * @param toppings - The Topping selected
     */
    public void setToppings(Toppings toppings) {
        // prevents the program from displaying toppings in the order
        // if the user didnt order pizza and if the topping is already in the
        // order
        if (size != null && !(this.toppings.contains(toppings))) {
            // adds the topping
            this.toppings.add(toppings);
        }
    }
    
    /**
     * Method to get the number of pizzas desired by the user
     * 
     * @param numPizzas - the number entered by the user
     */
    public void setNumPizzas(int numPizzas) {
        // checks to see if the user entered a valid number(cant order 0 pizzas)
        if (numPizzas > 0) {
            // sets the number of pizzas to numPizzas
            this.numPizzas = numPizzas;
        } else {
            // otherwise, lets the user know they need to enter a number greater
            // than 0
            throw new IllegalArgumentException("Error: You must enter a number"
                    + " greater than 0");
        }
    }

    /**
     * Method to get the number of drinks desired by the user
     * 
     * @param numDrinks - the number entered by the user
     */
    public void setNumDrinks(int numDrinks) {
        // checks to see if the user entered a valid number(cant order 0 drinks)
        if (numDrinks > 0) {
            // sets the number of drinks to numDrinks
            this.numDrinks = numDrinks;  
        } else {
            // otherwise, lets the user know they need to enter a number greater
            // than 0
            throw new IllegalArgumentException("Error: You must enter a number"
                    + " greater than 0");
        }
    }
    
    /**
     * Method that calculates and returns the subtotal amount
     * 
     * @return subtotal - the subtotal amount for the receipt
     */
    public double getSubtotal(){
        // initializes subtotal to 0
        double subtotal = 0.0;
        
        // checks if the user selected a size for the pizza
        if (size != null) {
            // multiplies the number of pizzas and the price of that size and 
            // adds it to the subtotal
            subtotal += numPizzas * size.getSizePrice();
            // adds the total price of the toppings to the subtotal
            subtotal += toppingTotal();
        }
        // checks to see if the user selected a drink
        if (drinks != null) {
            // multiplies the number of drinks selected by the price of 
            // the selected drink and adds it to the subtotal
            subtotal += numDrinks * drinks.getDrinkPrice();
        }
        
        //returns subtotal
        return subtotal;
    }
    
    /**
     * Method to calculate and return the price of the selected toppings
     * given the number of desired pizzas
     * 
     * @return total - the total price of the toppings
     */
    public double toppingTotal(){
        // initializes total to 0
        double total = 0.0;
        
        //goes through each topping selected
        for (Toppings topping : toppings) {
            // multiplies the number of pizzas by the price of the topping 
            // and adds it to the total
            total += numPizzas * topping.getToppingPrice();
        }
        
        // returns total
        return total;
    }
    
    /**
     * toString method which creates and returns a string format for a receipt
     * 
     * @return returnVal - the value to be returned to the user
     */
    @Override
    public String toString() {
        // initialize the returnVal to an empty string
        String returnVal = "";
        
        // checks to see if the user entered a size
        if (size != null) {
            // adds the information for the number of pizzas and the size to
            //returnVal
            returnVal += String.format("%-9s%21.2f\n%4d %s\n%-9s%21.2f\n"
                    , "PIZZA:", numPizzas * size.getSizePrice(), numPizzas
                    , size.toString(), "TOPPINGS:", toppingTotal());
            // adds the information for each topping selected to the returnVal
            for (Toppings topping : toppings) {
                returnVal += String.format("%4d %s\n", numPizzas
                        , topping.toString());
            }
        }
        
        // checks to see if the user entered a drink
        if (drinks != null) {
            // adds the information for the number and the type of drink to
            //returnVal
            returnVal += String.format("%-9s%21.2f\n%4d %s\n", "DRINKS:"
                    , numDrinks * drinks.getDrinkPrice(), numDrinks
                    , drinks.toString());
        }
        
        // adds a divider and the subtotal to returnVal
        returnVal += String.format("%s\n%-9s%21.2f", "=".repeat(31),"Subtotal:"
                , getSubtotal());
        
        // returns the resulting string
        return returnVal;
    }
    
}
