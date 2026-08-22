

class keyboard
{
    int keys;  // instant variable : stored with objects
    String color;

    public void press()
    {
        System.out.println("Key is pressed");
    }

    public void hit()
    {
        int distance = 7; // local variable, stored in it's own stack of function
        System.out.println("Key is hitted at a distance of " + distance);
    }
}


class AdvKeyboard extends keyboard
{
    public void hitNum()
    {
        System.out.println("Key is hitted with NUM");
    }
}


class inheritance 
{
    public static void main(String arg[])  // files start from here
    {
        AdvKeyboard obj = new AdvKeyboard();

        obj.keys = 101;
        obj.press();
        obj.hit();
        obj.hitNum();
    }
}



Types of inheritance : 

* There is no multiple inheritance in java, as there may ambiguity issue in child class, if it is inherited from multiple class.


* There exist default constructor in java, we can create custom constructor too.


class keyboard
{
    int keys;  // instant variable : stored with objects
    String color;

    public keyboard(){
        keys = 100;
        color = "white";
    }

    public void press()
    {
        System.out.println("Key is pressed");
    }

    public void hit()
    {
        int distance = 7; // local variable, stored in it's own stack
        System.out.println("Key is hitted at a distance of " + distance);
    }
}



* Encapsulation : 

It means varibles and methods should be binded together. Means, noone should directly able to access varibles outside the class.

--- means varibles should be private.
--- And have getter and setter method on each of varibles.
--- this pointer(this.variable_name) is used in order to make reference of objects of class.




* Polymorphism

--- method overriding


class AdvKeyboard extends keyboard
{
    public void hit()
    {
        int distance = 9; // local variable, stored in it's own stack of function
        System.out.println("Key is hitted at a distance of " + distance);
    }
}


class inheritance 
{
    public static void main(String arg[])  // files start from here
    {
        AdvKeyboard obj = new AdvKeyboard();

        obj.hit();  // will call method as per type of objects
    }
}


--- Method overloading is alos possible. : compile time polymorphism
--- Method overriding : runtime polymorphism



* Abstraction :

