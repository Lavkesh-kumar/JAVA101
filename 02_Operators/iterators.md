# Loops

## while
Runs as long as condition is true.

```java
int i = 0;
while(i < 4) {
    System.out.println(i);
    i++;
}
```


## do-while
Runs at least once — checks condition after each iteration.

```java
int i = 0;
do {
    System.out.println(i);
    i++;
} while(i < 4);
```


## for
Used when number of iterations is known.

```java
for(int i = 0; i < 4; i++) {
    System.out.println(i);
}
```


## for-each
Used to iterate over arrays and collections.

```java
int[] nums = {10, 20, 30, 40};
for(int n : nums) {
    System.out.println(n);
}

String[] names = {"Alice", "Bob", "Charlie"};
for(String name : names) {
    System.out.println(name);
}
```


## break & continue

### break — exits the loop immediately
```java
for(int i = 0; i < 10; i++) {
    if(i == 5) break;
    System.out.println(i);   // prints 0 to 4
}
```

### continue — skips current iteration, moves to next
```java
for(int i = 0; i < 5; i++) {
    if(i == 2) continue;
    System.out.println(i);   // prints 0, 1, 3, 4  (skips 2)
}
```


## Nested Loops
```java
for(int row = 1; row <= 3; row++) {
    for(int col = 1; col <= 3; col++) {
        System.out.print(row * col + " ");
    }
    System.out.println();
}
```


## Quick Comparison

| Loop      | Use when                                  | Runs at least once |
|-----------|-------------------------------------------|--------------------|
| while     | condition checked before each iteration   | NO                 |
| do-while  | condition checked after each iteration    | YES                |
| for       | number of iterations is known             | NO                 |
| for-each  | iterating over array / collection         | NO                 |
