Conditional Statements :


// if / else if / else
int num1 = 9;
int num2 = 5;

if(num1 > num2)
{
    System.out.println("num1 is greater than num2");
}
else if(num1 == num2){
    System.out.println("num1 is equal to num2");
}
else{
    System.out.println("num1 is less than num2");
}


// Nested if
if(num1 > 0){
    if(num1 > 100){
        System.out.println("num1 is large positive");
    } else {
        System.out.println("num1 is small positive");
    }
}


Ternary Operator :  condition ? valueIfTrue : valueIfFalse

int num1 = 9;
int res = 0;

res = num1 > 0 ? 5 : 10;   // res = 5

// nested ternary
String result = num1 > 0 ? "positive" : (num1 < 0 ? "negative" : "zero");


Switch :

int num1 = 9;

switch(num1)
{
    case 1:
        System.out.println("one");
        break;
    case 2:
        System.out.println("two");
        break;
    default:
        System.out.println("default");
        break;
}

// without break -> fall-through (executes all cases below the match)
switch(num1)
{
    case 1:
    case 2:
        System.out.println("one or two");   // runs for both case 1 and 2
        break;
    default:
        System.out.println("other");
}

// switch works with : int, char, String, enum
switch("hello")
{
    case "hello": System.out.println("Hi!"); break;
    case "bye":   System.out.println("Bye!"); break;
}
