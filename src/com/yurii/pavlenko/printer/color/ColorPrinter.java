package com.yurii.pavlenko.printer.color;

import com.yurii.pavlenko.printer.Printer;

/**
 * Specialized printer that overrides string printing behavior.
 */
public class ColorPrinter extends Printer {

    /**
     * Overrides the parent print(String) method.
     * Note: print(int) is still inherited as-is from the Printer class.
     * @param message the string to be printed in "color" format.
     */
    @Override
    public void print(String message) {
        System.out.println("Colored string: " + message);
    }
}