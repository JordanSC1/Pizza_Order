/*
    Drinks.java
    Author: Jordan Graham
    Date: March 25th, 2020

    Description
    Drinks is an enumeration class used to represent the list of possible 
    drinks for an order
    */
package grahajor;

/**
 *
 * @author jrgra
 */
public enum Drinks {
    // declaring the valid constants and their values
    COKE("Coke", 1.25),
    JUICE("Juice", 1.95),
    CHOCOLATE_MILK("Chocolate Milk", 2.25);
    
    // assigning the first value of each constant to drinkName
    private String drinkName;
    // assigning the second value of each constant to drinkPrice
    private double drinkPrice;

    /**
     * constructor for the drink of an order.
     *
     * @param drinkName the name corresponding to drink's name
     * @param drinkPrice the the price of the drink
     */
    private Drinks(String drinkName, double drinkPrice) {
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
    }

    /**
     * getter function for the drinkName
     *
     * @return the name corresponding to the drink
     */
    public String getDrinkName() {
        return drinkName;
    }

    /**
     * getter function for the drinkPrice
     *
     * @return the price corresponding to the drink
     */
    public double getDrinkPrice() {
        return drinkPrice;
    }

    /**
     * toString method which creates and returns a string format the name and
     * price of a drink
     * 
     * @return the formatted string 
     */
    @Override
    public String toString() {
        return String.format("%s @ %.2f", drinkName, drinkPrice);
    }
    
}
