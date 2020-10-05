/*
    PizzaSize.java
    Author: Jordan Graham
    Date: March 25th, 2020

    Description
    PizzaSize is an enumeration class used to represent the list of possible 
    sizes for a pizza
    */
package grahajor;

/**
 *
 * @author jrgra
 */
public enum PizzaSize {
    // declaring the valid constants and their values
    SMALL("Small", 5.25),
    MEDIUM("Medium", 7.50),
    LARGE("Large", 9.95);
    
    // assigning the first value of each constant to sizeName
    private String sizeName;
    // assigning the second value of each constant to sizePrice
    private double sizePrice;

    /**
     * constructor for the size of a pizza.
     *
     * @param sizeName the name corresponding to size's name
     * @param sizePrice the the price of the size
     */
    private PizzaSize(String sizeName, double sizePrice) {
        this.sizeName = sizeName;
        this.sizePrice = sizePrice;
    }
    
    /**
     * getter function for the sizeName
     *
     * @return the name corresponding to the size
     */
    public String getSizeName() {
        return sizeName;
    }
    
    /**
     * getter function for the sizePrice
     *
     * @return the price corresponding to the size
     */
    public double getSizePrice() {
        return sizePrice;
    }

    /**
     * toString method which creates and returns a string format the name and
     * price of a pizza size
     * 
     * @return the formatted string 
     */
    @Override
    public String toString() {
        return String.format("%s @ %.2f", sizeName, sizePrice);
    }
    
}
