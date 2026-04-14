package com.yurii.pavlenko.app;

import com.yurii.pavlenko.printer.color.ColorPrinter;

/**
 * Entry point to demonstrate overloading and overriding synergy.
 */
public class PrintingLauncherApp {

    public static void main(String[] args) {
        // Create an instance of the specialized ColorPrinter
        ColorPrinter printer = new ColorPrinter();

        // Calls the inherited (overloaded in parent) method
        printer.print(5);

        // Calls the overridden method in the child class
        printer.print("Hello");
    }
}