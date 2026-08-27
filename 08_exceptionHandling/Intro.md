# Exception Handling

## Errors
1. Compiler error — syntax mistake, caught before running
   ```java
   int x = "hello"; // Type mismatch — won't compile
   ```

2. Logical error — code runs but gives wrong output
   ```java
   int avg = 10 + 20 / 2; // Intended (10+20)/2=15, but gets 10+10=20
   ```

3. Runtime error — crashes during execution (exceptions)
   ```java
   int res = 10 / 0; // ArithmeticException at runtime
   ```


## Statements

1. Normal statement — always safe
   ```java
   int i = 5;
   String name = "Java";
   ```

2. Critical statement — may throw an exception
   ```java
   int res = i / j;          // ArithmeticException if j = 0
   arr[10];                  // ArrayIndexOutOfBoundsException
   String s = null;
   s.length();               // NullPointerException
   int x = Integer.parseInt("abc"); // NumberFormatException
   ```


## Main Idea — try / catch
Wrap critical statements in a `try` block. Handle the exception in `catch`.
- Exceptions are classes — you catch them by their type.
- If an exception occurs in `try`, the rest of `try` is skipped and `catch` runs.

```java
int i = 10, j = 0;
try {
    int res = i / j;                          // throws ArithmeticException
    System.out.println("Result: " + res);     // skipped
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage()); // / by zero
}
System.out.println("Program continues...");   // always runs
```


## Multiple catch Blocks
One `try` can have multiple `catch` blocks for different exception types.
- More specific exceptions must come before general ones.

```java
try {
    int[] arr = new int[3];
    arr[5] = 10;                              // ArrayIndexOutOfBoundsException
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Index error: " + e.getMessage());
} catch (Exception e) {                       // catches anything else
    System.out.println("General error: " + e.getMessage());
}
```


## Checked Exception
Compiler forces you to handle it — compile error if not caught or declared.
Common: `IOException`, `SQLException`, `FileNotFoundException`

```java
try {
    FileReader fr = new FileReader("file.txt"); // FileNotFoundException
    fr.close();
} catch (IOException e) {
    System.out.println("File error: " + e.getMessage());
}
```


## Unchecked Exception
Compiler does NOT enforce handling — occurs at runtime.
Common: `ArithmeticException`, `NullPointerException`, `ArrayIndexOutOfBoundsException`

```java
String s = null;
System.out.println(s.length()); // NullPointerException — no compile warning
```


## finally Block
Always executes — whether an exception occurs or not.
Used for cleanup: closing files, DB connections, releasing resources.

```java
FileReader fr = null;
try {
    fr = new FileReader("data.txt");
    System.out.println("File opened");
} catch (IOException e) {
    System.out.println("File not found");
} finally {
    System.out.println("finally always runs"); // runs in both cases
    if (fr != null) {
        try { fr.close(); } catch (IOException e) { e.printStackTrace(); }
    }
}
```


## throw
Manually throw an exception using the `throw` keyword.

```java
void checkAge(int age) {
    if (age < 0) {
        throw new ArithmeticException("Age cannot be negative: " + age);
    }
    System.out.println("Valid age: " + age);
}
```


## throws
Declare that a method may throw a checked exception — the caller must handle it.

```java
void readFile(String path) throws IOException {
    FileReader fr = new FileReader(path); // not handled here, passed to caller
}

// caller must handle it
try {
    readFile("data.txt");
} catch (IOException e) {
    System.out.println("Caught in caller: " + e.getMessage());
}
```


## Custom Exception
Extend `Exception` for checked, or `RuntimeException` for unchecked.

```java
class InvalidAgeException extends RuntimeException {
    InvalidAgeException(String msg) {
        super(msg);
    }
}

void setAge(int age) {
    if (age < 0) throw new InvalidAgeException("Invalid age: " + age);
    System.out.println("Age set to: " + age);
}

// usage
try {
    setAge(-5);
} catch (InvalidAgeException e) {
    System.out.println(e.getMessage()); // Invalid age: -5
}
```


## try-with-resources
Automatically closes resources — no need for explicit `finally`.
Resource class must implement `AutoCloseable`.

```java
try (FileReader fr = new FileReader("data.txt")) {
    System.out.println("Reading file...");
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
// fr.close() called automatically
```


## Exception Hierarchy
```
Throwable
├── Error              (JVM-level, don't catch — OutOfMemoryError, StackOverflowError)
└── Exception
    ├── IOException              (checked)
    ├── SQLException             (checked)
    └── RuntimeException         (unchecked)
        ├── ArithmeticException
        ├── NullPointerException
        ├── NumberFormatException
        └── ArrayIndexOutOfBoundsException
```
