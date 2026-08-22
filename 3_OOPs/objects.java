// till now everything we learn was java fundamentals


class keyword
{
    int keys;  // instant variable : stored with objects
    String color;

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


class objects 
{
    public static void main(String arg[])  // files start from here
    {
        keyword obj = new keyword();

        obj.keys = 101;
        obj.press();
        obj.hit();
    }
}

