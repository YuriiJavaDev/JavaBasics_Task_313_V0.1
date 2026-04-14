### You're developing an advanced printing system that can handle various data types and also has a special mode for printing certain messages in color.

#### - Create a base Printer class. Within Printer, create two methods named print: one should accept an integer (int) and print "Number: X," where X is the number passed in. The second print method should accept a string (string) and print "String: Y," where Y is the string passed in.

#### - Now extend your system by creating a ColorPrinter class that inherits from Printer. ColorPrinter should be able to intercept and modify string printing behavior. Override the print(String) method in ColorPrinter to print "Colored string: Y." Make sure you're overriding the method, not overloading it.

#### - In the main method, create a ColorPrinter object. Demonstrate its capabilities: first call the print method with a number (e.g., 5), and then call the print method with a string (e.g., "Hello"). Your program should show that the number is printed in the standard format, and the string is printed with color formatting, outputting: "Number: 5" and "Colored string: Hello."

```java
public class Solution {
    public static void main(String[] args) {
        // Create a child class object
        ColorPrinter printer = new ColorPrinter();

        // Demonstration: overload in base class + override in child
        printer.print(5); // Printer#print(int) method is called
        printer.print("Hello"); // the overridden ColorPrinter#print(String) method is called
    }
}
```
