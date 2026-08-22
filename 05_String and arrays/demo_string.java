

// strings are Immutable
// we can make it mutable by using StringBuffer


class demo_string 
{
    public static void main(String arg[])  // files start from here
    {
        String s = "lavkesh";

        String s1 = "lavkesh"; // It will point to same object(string literal) as s.

        s = s + " kumar"; // It will create new objects. 

        int n = s.length();

        StringBuffer t = new StringBuffer("lavkesh");
        t.append(" kumar"); // this will modify the exisiting object.
    }
}
