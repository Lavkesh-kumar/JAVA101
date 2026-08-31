Operators in Java :

Arithmetic  : +, -, *, /, %
Relational  : ==, !=, <, <=, >, >=
Logical     : &&, ||, !
Assignment  : =, +=, -=, *=, /=, %=
Unary       : ++, --, + (unary plus), - (unary minus), ! (not)
Bitwise     : &, |, ^, ~, <<, >>


int num1 = 9;
int num2 = 5;

int res = num1 + num2;   // 14
res = num1 % num2;       // 4  (remainder)
res = num1 / num2;       // 1  (integer division)

// Unary
num1++;   // num1 = 10  (post-increment)
++num1;   // num1 = 11  (pre-increment)
num1--;   // num1 = 10  (post-decrement)

// Assignment shorthand
num1 += 5;   // num1 = num1 + 5
num1 -= 2;   // num1 = num1 - 2
num1 *= 3;   // num1 = num1 * 3

// Operator precedence (high to low) :
// 1. ()  -- parentheses
// 2. ++, --
// 3. *, /, %
// 4. +, -
// 5. <, <=, >, >=
// 6. ==, !=
// 7. &&
// 8. ||
// 9. =, +=, -=, ...

int result = 10 + 2 * 5;    // 20  (not 60, * runs before +)
int result2 = (10 + 2) * 5; // 60  (parentheses first)
