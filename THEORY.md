## Method overriding: different from overloading.

### 1. Method Overriding

Overriding is the ability to write a custom version of a method in a subclass that already exists in the parent class. This enables true polymorphism at runtime.

**In simple terms:**

If you have a base class with a method, and you want a subclass to implement that method differently, you simply declare a method with the same signature in the subclass. When the method is called through a reference to the base type, the version of the method from the actual object type will be called.

**A real-life example.**

Imagine you have a team of animals, and you ask each one to "make a sound." To everyone, the command is **makeSound()**, but a dog barks, a cat meows, and a cow moos. To the code, it looks like they're calling the same method, but the result is different—that's the magic of overriding!

#### Overriding Syntax

#### Basic Example

```java
class Animal {
    void makeSound() {
    System.out.println("An animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
    System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
    System.out.println("Meow!");
    }
}
```

Here, the **Animal** class defines the **makeSound()** method. The **Dog** and **Cat** subclasses override this method, providing their own implementation.

#### @Override Annotation

In Java, it's recommended (and a good habit) to mark overridden methods with the **@Override** annotation:

```java
    @Override
    void makeSound() { ... }
```

This isn't required for the code to work, but:

- The compiler will check whether you're actually overriding the method (and not accidentally misspelling the name or parameters).
- Improves code readability—other programmers can immediately see that this method overrides its parent.

#### Calling an Overridden Method

```java
    Animal myDog = new Dog();
    myDog.makeSound(); // Outputs: Woof!
```

Even though the variable is of type **Animal**, it actually points to a **Dog** object, and a method from the **Dog** class is called. This is dynamic (late) binding.

### 2. The difference between overriding and overloading

#### Overloading

- In the same class (or in a hierarchy, but always "nearby").
- Methods have the same name but different parameters (type, number, order).
- Method selection occurs at compile time.

```java
    void print(int x) { ... }
    void print(String s) { ... }
```

#### Overriding

- In different classes: a method declared in a superclass and overridden in a subclass.
- Methods have the same name and signature (parameters and return type).
- Method selection occurs at runtime, based on the actual type of the object.

#### Comparison Table

| | **Overloading** | **Overriding** |
| --- | --- | --- |
| Where | In the same class | In a superclass and subclass |
| Method Name | Same | Same |
| Parameters | Different | Same |
| Return Type | May be different | Must be the same or a subtype |
| When Chosen | Compilation | Runtime |
| Abstract | Not Required | @Override (Recommended) |

### 3. Method Overriding Rules

Overriding is powerful, but it comes with strict rules. Let's go through them one by one.

#### Method signature must match

- The method name, types, and parameter order must be identical to the method in the superclass.
- The return type must be the same or **covariant** (i.e., a subtype of the parent method's return type).

**Example with a covariant return type:**

```java
class Animal {
    Animal reproduce() {
        return new Animal();
    }
}

class Cat extends Animal {
    @Override
    Cat reproduce() {
        return new Cat(); // OK! Cat is a subtype of Animal
    }
}
```

#### Access Modifier

The access modifier of an overridden method cannot be more restrictive than that of the method in the superclass. If a method is public in the parent, it must remain public in the subclass. It cannot be made less accessible (protected or private).

**Example:**

```java
class Parent {
    public void greet() { }
}
class Child extends Parent {
    // void greet() { } // Error! The default modifier is package-private, less accessible than public.
    @Override
    public void greet() { } // OK
}
```

#### Exceptions

- An overridden method cannot throw new checked exceptions that are not declared in the base method.
- It is possible to throw fewer or the same exceptions.

**Example:**

```java
class Parent {
    void doWork() throws IOException { }
}
class Child extends Parent {
    @Override
    void doWork() throws FileNotFoundException { } // OK, FileNotFoundException is a subtype of IOException
    // void doWork() throws SQLException { } // Error! SQLException is not declared in the parent.
}
```

#### Static methods cannot be overridden

Static methods can be hidden, but they cannot be overridden. If you declare a static method with the same signature in a subclass, that's not overriding! That's just method hiding, not polymorphism.

```java
class Animal {
    static void info() {
        System.out.println("Animal");
    }
}
class Dog extends Animal {
    static void info() {
        System.out.println("Dog");
    }
}
```

Calling Dog.info() will print "Dog", but if called through an Animal variable, the Animal.info() method will be called. That's not polymorphism!

#### final methods cannot be overridden

If a method in a superclass is declared final, attempting to override it will result in a compile-time error.

```java
class Animal {
    final void sleep() { }
}
    class Dog extends Animal {
    // @Override
    // void sleep() { } // Error! You can't override a final method
}
```

### 4. Practical Examples

Let's take a practical look at how overriding works and how it differs from overloading.

#### Example 1: The Shape Class and Its Descendants

```java
class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}
```

Using polymorphism:

```java
public class Main {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        Shape s2 = new Rectangle();
        s1.draw(); // Draw a circle
        s2.draw(); // Draw a rectangle
    }
}
```

Even though the variables are declared as Shape, the method of the class to which the object actually belongs is called.

#### Example 2: Difference from overloading

```java
class Printer {
    void print(String s) {
        System.out.println("String: " + s);
    }
    
    void print(int n) {
        System.out.println("Number: " + n);
    }
}
```

Here, both methods are called print, but they have different parameters—this is overloading, not overriding.

### 5. Overriding and Calling a Parent Method (super)

Sometimes in an overridden method, you want to first execute the parent's logic and then add your own. The super keyword is used for this.

```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        super.makeSound(); // Call the parent's method
        System.out.println("Woof!");
    }
}
```

Calling new Dog().makeSound() will output:

```
Animal makes a sound
Woof!
```

#### How Late Binding Works

When you call a method through a base type reference, Java looks at runtime to see which real object this reference refers to and calls the version of the method defined in that object's class.

```java
Animal a = new Cat();
a.makeSound(); // Calls Cat.makeSound(), not Animal.makeSound()
```

This is the basis of polymorphism in Java.

### 6. How this relates to your application

In our sample application (for example, an employee accounting system), you can create a base class Employee with a work() method, and the Manager and Developer subclasses can implement this method differently:

```java
class Employee {
    void work() {
        System.out.println("Employee is working");
    }
}

class Manager extends Employee {
    @Override
    void work() {
        System.out.println("The manager manages");
    }
}

class Developer extends Employee {
    @Override
    void work() {
        System.out.println("The developer writes code");
    }
}
```

Now you can store all employees in a single array or list:

```java
    Employee[] employees = {new Manager(), new Developer(), new Developer()};
        for (Employee e : employees) {
        e.work(); // Output for each!
        }
```

### 7. Common mistakes when overriding methods

**Error 1: Typo in the method name or parameters.** If you accidentally make a mistake in the method name or its parameters, you are not overriding the method, but creating a new one. As a result, polymorphism doesn't work. This is why you should always use the @Override annotation—the compiler will correct you immediately.

**Error 2: Stricter access modifier.** If a method in the parent class is public, but in the child class you declare it as protected or without a modifier, you will get a compilation error.

**Error 3: Attempting to override a static or final method.** Static methods cannot be overridden, and final methods cannot be overridden at all. If you try this, the compiler will stop you.

**Error 4: Changing the return type to an incompatible one.** If the return type of a method in a subclass doesn't match the type in the superclass (and is not a subtype of it), the compiler will not allow you to override the method.

**Error 5: Adding new checked exceptions.** An overridden method cannot throw new checked exceptions that are not present in the base method declaration. If you do, the compiler will generate an error.

**Error 6: Forgetting about super.** If you want to preserve some of the parent's behavior in an overridden method, be sure to explicitly call super.methodName(). Java won't do this automatically.

#### Now you know how method overriding works, how it differs from overloading, and how it implements polymorphism in Java. In the next lesson, we'll look at how to apply polymorphism in practice—with collections, arrays, and real-world problems!
