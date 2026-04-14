package com.yurii.pavlenko.printer;

/**
 * Base printer class demonstrating method overloading.
 */
public class Printer {

    /**
     * Overloaded method to print integers.
     * @param number the integer value to print.
     */
    public void print(int number) {
        System.out.println("Number: " + number);
    }

    /**
     * Overloaded method to print strings.
     * @param message the string message to print.
     */
    public void print(String message) {
        System.out.println("String: " + message);
    }
}