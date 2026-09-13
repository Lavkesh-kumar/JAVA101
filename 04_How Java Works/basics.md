# How Java Works

## Java Platform Components

### JDK (Java Development Kit)
The full toolkit for developing Java applications. It includes the compiler (`javac`), debugger, and other dev tools.

### JRE (Java Runtime Environment)
Provides the libraries and runtime needed to **run** Java programs. Does not include the compiler.

### JVM (Java Virtual Machine)
Executes Java bytecode. It is platform-specific, but bytecode is platform-independent.

**Containment hierarchy:**

```
JDK  ⊃  JRE  ⊃  JVM
```

---

## Compilation & Execution Flow

```
Source Code         Compiler       Bytecode         Runtime
  file.java   →    (javac)    →   file.class   →   JVM executes
```

- The Java compiler converts `.java` source files into `.class` bytecode files.
- For every class defined in a `.java` file, JVM creates a **separate `.class` file**.
- The JVM interprets/compiles bytecode at runtime — this is what makes Java **platform independent**.

> "Write Once, Run Anywhere" — as long as a JVM exists for the target platform, Java bytecode can run on it.

---

## JVM Memory Model

### Heap Memory
- Stores **objects** and **instance variables**.
- Shared across all threads.
- Managed by the **Garbage Collector**, which automatically frees memory for unreferenced objects.

### Stack Memory
- Each method call creates a new **stack frame**.
- Stores **local variables** and method call info.
- Stack frame is destroyed when the method returns.
- Each thread has its own stack.

### Method Area (Class Area)
- Stores **class-level data**: class structure, static variables, method bytecode.
- Shared across all threads.

### Memory Layout Example

```java
class Keyboard {
    int keys;       // instance variable → Heap
    static int count = 0; // static variable → Method Area

    public void press() {
        int volume = 5; // local variable → Stack (press() frame)
    }
}
```

---

## Static Variables & Methods

- Static members belong to the **class**, not to any instance.
- Accessed directly via `ClassName.memberName` without creating an object.
- Stored in the **Method Area**.

```java
class Keyboard {
    static int count = 0;

    public Keyboard() {
        count++; // shared across all instances
    }
}

// Access without an object:
System.out.println(Keyboard.count);
```

---

## Class Loading

When a Java program runs, the **ClassLoader** (part of JVM) loads `.class` files into memory in three steps:

1. **Loading** — reads the `.class` file and brings it into memory.
2. **Linking** — verifies bytecode, allocates memory for static variables.
3. **Initialization** — executes static initializers and assigns static variable values.

---

## JIT Compiler (Just-In-Time)

The JVM includes a **JIT compiler** that optimizes performance at runtime:

- Interprets bytecode initially.
- Detects "hot" code (frequently executed) and compiles it to **native machine code**.
- Subsequent calls use the faster native version.

```
Bytecode → JVM Interpreter → (hot path) → JIT Compiler → Native Code
```

---

## Summary

| Component | Role |
|---|---|
| JDK | Develop + compile Java programs |
| JRE | Run Java programs (includes JVM + libraries) |
| JVM | Execute bytecode; manages memory and threads |
| Heap | Object and instance variable storage |
| Stack | Method frames and local variables |
| Method Area | Class metadata and static members |
| JIT Compiler | Optimizes hot bytecode to native machine code |
| ClassLoader | Loads `.class` files into JVM at runtime |
