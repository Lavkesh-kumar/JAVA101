# Java OOP Concepts

## 1. Inheritance

Inheritance allows a child class to acquire properties and methods of a parent class using the `extends` keyword.

```java
class Keyboard {
    int keys;           // instance variable: stored with object
    String color;

    public void press() {
        System.out.println("Key is pressed");
    }

    public void hit() {
        int distance = 7; // local variable: stored in method's stack frame
        System.out.println("Key hit at distance: " + distance);
    }
}

class AdvKeyboard extends Keyboard {
    public void hitNum() {
        System.out.println("Numpad key hit");
    }
}

class Main {
    public static void main(String[] args) {
        AdvKeyboard obj = new AdvKeyboard();
        obj.keys = 101;
        obj.press();   // inherited from Keyboard
        obj.hit();     // inherited from Keyboard
        obj.hitNum();  // defined in AdvKeyboard
    }
}
```

### Types of Inheritance in Java

| Type | Supported | Notes |
|---|---|---|
| Single | ✅ | One parent, one child |
| Multilevel | ✅ | A → B → C |
| Hierarchical | ✅ | One parent, multiple children |
| Multiple | ❌ | Not supported via classes (use interfaces) |
| Hybrid | ⚠️ | Partially via interfaces |

> Java does **not** support multiple class inheritance to avoid the **Diamond Problem** — ambiguity when two parent classes have the same method.

---

## 2. Constructors

A constructor initializes an object when it is created. Java provides a default no-arg constructor if none is defined.

```java
class Keyboard {
    int keys;
    String color;

    // Default constructor
    public Keyboard() {
        keys = 100;
        color = "white";
    }

    // Parameterized constructor
    public Keyboard(int keys, String color) {
        this.keys = keys;
        this.color = color;
    }
}
```

- `this` refers to the current object instance, used to distinguish instance variables from parameters.
- Use `super()` in a child class constructor to call the parent class constructor.

```java
class AdvKeyboard extends Keyboard {
    boolean hasNumpad;

    public AdvKeyboard(int keys, String color, boolean hasNumpad) {
        super(keys, color); // calls Keyboard(int, String)
        this.hasNumpad = hasNumpad;
    }
}
```

---

## 3. Encapsulation

Encapsulation binds data (variables) and behavior (methods) together inside a class, and restricts direct access to internal state.

- Declare fields as `private`
- Expose them via `public` getters and setters

```java
class Keyboard {
    private int keys;
    private String color;

    public int getKeys() { return keys; }
    public void setKeys(int keys) { this.keys = keys; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}
```

Benefits: data hiding, controlled access, easier maintenance.

---

## 4. Polymorphism

Polymorphism means "many forms" — the same method behaves differently based on context.

### Method Overriding (Runtime Polymorphism)

A child class provides its own implementation of a method defined in the parent class.

```java
class Keyboard {
    public void hit() {
        System.out.println("Key hit at distance: 7");
    }
}

class AdvKeyboard extends Keyboard {
    @Override
    public void hit() {
        System.out.println("Key hit at distance: 9"); // overridden behavior
    }
}

class Main {
    public static void main(String[] args) {
        Keyboard obj = new AdvKeyboard();
        obj.hit(); // calls AdvKeyboard's hit() at runtime
    }
}
```

### Method Overloading (Compile-time Polymorphism)

Same method name, different parameter lists — resolved at compile time.

```java
class Keyboard {
    public void hit() {
        System.out.println("Hit with default distance");
    }

    public void hit(int distance) {
        System.out.println("Hit at distance: " + distance);
    }
}
```

---

## 5. Abstraction

Abstraction hides implementation details and exposes only essential behavior. Achieved via `abstract` classes or `interfaces`.

### Abstract Class

```java
abstract class Keyboard {
    abstract void hit(); // no body — must be implemented by subclass

    public void press() {
        System.out.println("Key pressed"); // concrete method
    }
}

class AdvKeyboard extends Keyboard {
    @Override
    public void hit() {
        System.out.println("Key hit at distance: 9");
    }
}
```

- Cannot instantiate an abstract class directly.
- Can have both abstract and concrete methods.

### Interface

```java
interface Typeable {
    void type(); // implicitly public and abstract
}

interface Backlit {
    void toggleLight();
}

// A class can implement multiple interfaces (unlike extends)
class AdvKeyboard extends Keyboard implements Typeable, Backlit {
    public void type() { System.out.println("Typing..."); }
    public void toggleLight() { System.out.println("Light toggled"); }
}
```

> Interfaces are Java's way of achieving multiple inheritance safely.

---

## Summary

| Concept | Purpose |
|---|---|
| Inheritance | Reuse code from parent class |
| Constructor | Initialize object state |
| Encapsulation | Hide internal data, expose via methods |
| Polymorphism | Same interface, different behavior |
| Abstraction | Hide complexity, show only essentials |
