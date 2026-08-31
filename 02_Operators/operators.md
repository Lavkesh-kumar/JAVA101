# Operators in Java

## Types of Operators

| Type       | Operators                        |
|------------|----------------------------------|
| Arithmetic | `+`  `-`  `*`  `/`  `%`         |
| Relational | `==`  `!=`  `<`  `<=`  `>`  `>=`|
| Logical    | `&&`  `\|\|`  `!`                  |
| Assignment | `=`  `+=`  `-=`  `*=`  `/=`  `%=`|
| Unary      | `++`  `--`  `+`  `-`  `!`       |
| Bitwise    | `&`  `\|`  `^`  `~`  `<<`  `>>`   |


## Examples

### Arithmetic
```java
int num1 = 9;
int num2 = 5;

int res = num1 + num2;   // 14
res = num1 % num2;       // 4  (remainder)
res = num1 / num2;       // 1  (integer division)
```

### Unary
```java
num1++;   // post-increment  ->  num1 = 10
++num1;   // pre-increment   ->  num1 = 11
num1--;   // post-decrement  ->  num1 = 10
```

### Assignment Shorthand
```java
num1 += 5;   // num1 = num1 + 5
num1 -= 2;   // num1 = num1 - 2
num1 *= 3;   // num1 = num1 * 3
```


## Operator Precedence (high to low)

| Priority | Operators          |
|----------|--------------------|
| 1        | `()`               |
| 2        | `++`  `--`         |
| 3        | `*`  `/`  `%`      |
| 4        | `+`  `-`           |
| 5        | `<`  `<=`  `>`  `>=` |
| 6        | `==`  `!=`         |
| 7        | `&&`               |
| 8        | `\|\|`               |
| 9        | `=`  `+=`  `-=` …  |

```java
int result  = 10 + 2 * 5;    // 20  (* runs before +)
int result2 = (10 + 2) * 5;  // 60  (parentheses first)
```
