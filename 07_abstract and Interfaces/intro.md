# Abstract Classes & Interfaces

## Abstract Class

An abstract class cannot be instantiated directly. It serves as a blueprint for subclasses, and can contain both **abstract** (unimplemented) and **concrete** (implemented) methods.

```java
abstract class Computer {
    public abstract void start();   // must be implemented by subclass

    public void shutdown() {        // concrete method — inherited as-is
        System.out.println("Shutting down...");
    }
}

class Laptop extends Computer {
    @Override
    public void start() {
        System.out.println("Laptop starting...");
    }
}
```

- A subclass **must** implement all abstract methods, or itself be declared `abstract`.
- Abstract classes can have constructors, fields, and non-abstract methods.
- A class can extend **only one** abstract class.

---

## Interface

An interface is a fully abstract contract — it defines what a class must do, not how.

```java
interface Computer {
    int PRICE = 100;  // implicitly public, static, and final (constant)
    void start();     // implicitly public and abstract
}

class Laptop implements Computer {
    @Override
    public void start() {
        System.out.println("Laptop starting...");
    }
}
```

### Default & Static Methods (Java 8+)

Interfaces can now have concrete methods using `default` and `static` keywords:

```java
interface Computer {
    void start();

    default void restart() {                        // concrete, inherited by implementing class
        System.out.println("Restarting...");
    }

    static void info() {                            // called via interface name
        System.out.println("Computer interface");
    }
}
```

### Multiple Interface Implementation

A class can implement multiple interfaces — Java's way of achieving multiple inheritance:

```java
interface Portable {
    void carry();
}

interface Chargeable {
    void charge();
}

class Laptop implements Computer, Portable, Chargeable {
    public void start()  { System.out.println("Starting..."); }
    public void carry()  { System.out.println("Carrying laptop..."); }
    public void charge() { System.out.println("Charging..."); }
}
```

### Interface Extending Interface

An interface can extend one or more other interfaces:

```java
interface SmartDevice extends Computer, Portable {
    void syncData();
}
```

---

## Abstract Class vs Interface

| Feature | Abstract Class | Interface |
|---|---|---|
| Instantiation | ❌ Cannot instantiate | ❌ Cannot instantiate |
| Abstract methods | ✅ Supported | ✅ All methods abstract by default |
| Concrete methods | ✅ Supported | ✅ Via `default`/`static` (Java 8+) |
| Fields | Any type | `public static final` only |
| Constructors | ✅ Supported | ❌ Not supported |
| Multiple inheritance | ❌ Single class only | ✅ A class can implement many |
| `extends` / `implements` | `extends` | `implements` |

---

## When to Use Which

- Use an **abstract class** when classes share common state (fields) or base behavior, and have a clear "is-a" relationship.
- Use an **interface** when you want to define a capability contract that unrelated classes can fulfill (e.g., `Serializable`, `Comparable`).

```java
// Abstract class: shared base behavior
abstract class Animal {
    String name;
    abstract void sound();
}

// Interface: capability contract
interface Swimmable {
    void swim();
}

class Duck extends Animal implements Swimmable {
    public void sound() { System.out.println("Quack"); }
    public void swim()  { System.out.println("Duck swimming"); }
}
```

---

## Summary

| Concept | Key Point |
|---|---|
| Abstract class | Blueprint with partial implementation; single inheritance |
| Abstract method | No body; subclass must override |
| Interface | Pure contract; supports multiple implementation |
| `default` method | Concrete method in interface (Java 8+) |
| Interface fields | Always `public static final` |
| Multiple interfaces | A class can implement many interfaces |
