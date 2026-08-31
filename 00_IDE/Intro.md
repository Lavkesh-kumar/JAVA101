# Java IDE & Basics

## IDE Options
- VS Code
- IntelliJ IDEA

## Java Compiler : JDK (Java Development Kit)
JDK contains -> JRE (Java Runtime Environment) contains -> JVM (Java Virtual Machine)

- JRE provides extra libraries for the application
- JVM executes the bytecode

## How Java Works
Java is both compiled and interpreted.

```
file.java  -->  compiler (JDK)  -->  file.class (bytecode)  -->  JVM (runs bytecode)
```

- Java is platform independent — wherever JVM exists, Java code can run.
- For every class in a .java file, JVM creates a separate .class (bytecode) file.

## JVM Memory
- Heap memory : Objects and instance variables are stored here.
- Stack memory : Method stacks are created here. Local variables of a method live in its stack frame.
- Main stack holds references to all objects.
- Static variables can be accessed directly as `ClassName.variableName`


## REPL — jshell
REPL = Read Evaluate Print Loop (run one line of code without a file)

```
jshell> System.out.println("Hello World");   // prints directly
jshell> int num = 5;
jshell> num                                  // prints 5
jshell> 2 * 4                                // prints 8
```


## First Java Program
```java
class Demo
{
    public static void main(String arg[])   // entry point
    {
        System.out.println("Hello World");
    }
}
```

Compile and run:
```
javac Demo.java    // creates Demo.class
java Demo          // runs the bytecode
```


## Primitive Data Types

| Type    | Description              |
|---------|--------------------------|
| byte    | small integer (8-bit)    |
| short   | 2 × byte (16-bit)        |
| int     | integer (32-bit)         |
| long    | large integer (64-bit)   |
| float   | decimal (32-bit)         |
| double  | decimal (64-bit)         |
| char    | single character         |
| boolean | true / false             |

```java
int num = 5;
double price = 9.99;
char grade = 'A';
boolean isActive = true;
```

Use `final` to make a variable constant (cannot be reassigned):
```java
final int MAX = 100;
```


## Type Casting
```java
// Widening (automatic)
int i = 10;
double d = i;       // int -> double

// Narrowing (manual)
double x = 9.99;
int y = (int) x;    // double -> int  =>  y = 9
```