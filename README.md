# Advanced Printing System: Overloading vs Overriding (JavaBasics_Task_313_V0.1)

## 📖 Description
Understanding the distinction between Overloading and Overriding is fundamental to mastering Java. This project implements an `Advanced Printing System` where a `ColorPrinter` utilizes both concepts. The base `Printer` class provides overloaded methods to handle different data types (int and String). The `ColorPrinter` subclass then overrides the specific `print(String)` method to provide specialized "colored" output. This demonstrates how subclasses can inherit certain behaviors while selectively modifying others to suit specific requirements.

## 📋 Requirements Compliance
- **Base Overloading**: Implemented two `print` methods in the `Printer` class with different parameter types.
- **Subclass Overriding**: Specialized the `print(String)` behavior in `ColorPrinter` while maintaining the exact method signature.
- **Inheritance Utilization**: Proven that the subclass can still access the non-overridden `print(int)` method from the parent.
- **Dynamic Behavior**: Verified that the program correctly selects the appropriate method at runtime based on the object type and parameters.

## 🚀 Architectural Stack
- Java 8+ (Inheritance, Method Overloading, Method Overriding)

## 🏗️ Implementation Details
- **Printer**: The base engine providing multi-type printing capabilities.
- **ColorPrinter**: The specialized engine that redefines string output logic.
- **PrintingLauncherApp**: The execution entry point simulating the system's usage.

## 📋 Expected result
```text
Number: 5
Colored string: Hello
```

## 💻 Code Example

Project Structure:

    JavaBasics_Task_313/
    ├── src/
    │   └── com/yurii/pavlenko/
    │                 ├── app/
    │                 │   └── PrintingLauncherApp.java
    │                 └── printer/
    │                     ├── color/
    │                     │   └── ColorPrinter.java
    │                     └── Printer.java
    ├── LICENSE
    ├── TASK.md
    ├── THEORY.md
    └── README.md

Code
```java
package com.yurii.pavlenko.app;

import com.yurii.pavlenko.printer.color.ColorPrinter;

public class PrintingLauncherApp {
    public static void main(String[] args) {
        ColorPrinter printer = new ColorPrinter();
        printer.print(5);
        printer.print("Hello");
    }
}
```
```java
package com.yurii.pavlenko.printer;

public class Printer {

    public void print(int number) {
        System.out.println("Number: " + number);
    }

    public void print(String message) {
        System.out.println("String: " + message);
    }
}
```
```java
package com.yurii.pavlenko.printer.color;

import com.yurii.pavlenko.printer.Printer;

public class ColorPrinter extends Printer {

    @Override
    public void print(String message) {
        System.out.println("Colored string: " + message);
    }
}
```

## ⚖️ License
This project is licensed under the **MIT License**.

Copyright (c) 2026 Yurii Pavlenko

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files...

License: [MIT](LICENSE)
