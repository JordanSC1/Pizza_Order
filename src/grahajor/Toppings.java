/*
    Toppings.java
    Author: Jordan Graham
    Date: March 25th, 2020

    Description
    Toppings is an enumeration class used to represent the list of possible 
    toppings for a pizza
    */
package grahajor;

/**
 *
 * @author jrgra
 */
public enum Toppings {
    // declaring the valid constants and their values
    CHEESE("Cheese", 1.00),
    MUSHROOMS("Mushrooms", 1.25),
    OLIVES("Olives", 1.50),
    PEPPERONI("Pepperoni", 1.75);
    
    // assigning the first value of each constant to toppingName
    private String toppingName;
    // assigning the second value of each constant to toppingPrice
    private double toppingPrice;

    /**
     * constructor for the topping of pizza.
     *
     * @param toppingName the name corresponding to topping's name
     * @param toppingPrice the the price of the topping
     */
    private Toppings(String toppingName, double toppingPrice) {
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
    }

    /**
     * getter function for the topingName
     *
     * @return the name corresponding to the topping
     */
    public String getToppingName() {
        return toppingName;
    }
    
    /**
     * getter function for the toppingPrice
     *
     * @return the price corresponding to the topping
     */
    public double getToppingPrice() {
        return toppingPrice;
    }
    
    /**
     * toString method which creates and returns a string format the name and
     * price of a topping
     * 
     * @return the formatted string 
     */
    @Override
    public String toString() {
        return String.format("%s @ %.2f", toppingName, toppingPrice);
    }
    
}
