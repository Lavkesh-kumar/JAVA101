conditional statement :


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


Ternary Operators : 


int num1 = 9;
int num2 = 5;
int res = 0;

res = num1 > 0 ? 5 : 10;



Switch : 

int num1 = 9;
int num2 = 5;
int res = 0;

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



