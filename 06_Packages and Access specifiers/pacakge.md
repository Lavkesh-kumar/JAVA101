# Packages & Access Modifiers

## Packages

A package is a namespace that groups related classes and interfaces — similar to folders in a file system.

**Benefits:**
- Avoids naming conflicts between classes
- Organizes code into logical modules
- Controls access with access modifiers

### Creating a Package

Declare the package as the **first statement** in a `.java` file:

```java
package com.lavkesh.src.app;

public class Keyboard {
    // class body
}
```

### Nested Packages

Packages can be nested (sub-packages), mirroring a directory structure:

```
com/
└── lavkesh/
    └── src/
        └── app/
            └── Keyboard.java
```

### Importing a Package

Use another package's class with the `import` statement:

```java
import com.lavkesh.src.app.Keyboard;       // import specific class
import com.lavkesh.src.app.*;              // import all classes in package
```

### Built-in Java Packages

| Package | Contents |
|---|---|
| `java.lang` | Core classes (`String`, `Math`, `Object`) — auto-imported |
| `java.util` | Collections, `ArrayList`, `HashMap`, `Scanner` |
| `java.io` | File and stream I/O |
| `java.net` | Networking |
| `java.sql` | Database connectivity (JDBC) |

---

## Access Modifiers

Access modifiers control the visibility of classes, fields, constructors, and methods.

### Scope Table

| Scope | `public` | `protected` | `default` | `private` |
|---|---|---|---|---|
| Same class | ✅ | ✅ | ✅ | ✅ |
| Same package subclass | ✅ | ✅ | ✅ | ❌ |
| Same package non-subclass | ✅ | ✅ | ✅ | ❌ |
| Different package subclass | ✅ | ✅ | ❌ | ❌ |
| Different package non-subclass | ✅ | ❌ | ❌ | ❌ |

### Quick Reference

- `public` — accessible from everywhere
- `protected` — accessible within the same package and subclasses (even across packages)
- `default` (no keyword) — accessible only within the same package
- `private` — accessible only within the same class

```java
public class Keyboard {
    public int keys;        // accessible everywhere
    protected String color; // accessible in subclasses
    int weight;             // default: same package only
    private String serial;  // this class only

    private String getSerial() { return serial; } // encapsulation
}
```

---

## `final` Keyword

`final` can be applied to variables, methods, and classes.

### `final` Variable
Value cannot be reassigned after initialization.

```java
final int MAX_KEYS = 104;
// MAX_KEYS = 200; // compile error
```

### `final` Method
Cannot be overridden by a subclass.

```java
class Keyboard {
    public final void press() {
        System.out.println("Key pressed");
    }
}

class AdvKeyboard extends Keyboard {
    // public void press() { } // compile error
}
```

### `final` Class
Cannot be subclassed (inherited).

```java
final class Keyboard { }

// class AdvKeyboard extends Keyboard { } // compile error
```

> `String` in Java is a `final` class — it cannot be extended.

---

## Summary

| Concept | Purpose |
|---|---|
| Package | Organizes classes, avoids naming conflicts |
| `import` | Brings classes from other packages into scope |
| `public` | Accessible from anywhere |
| `protected` | Accessible in same package + subclasses |
| `default` | Accessible within same package only |
| `private` | Accessible within same class only |
| `final` variable | Constant — value cannot change |
| `final` method | Cannot be overridden |
| `final` class | Cannot be inherited |
