
abstract class computer
{
    public abstract void f();
    public void g() {}
}

class laptop extends computer
{

}


interface computer
{
    int price = 100; // final as well static by default
    void f(); // by default public and abstract
}

class laptop implements computer
{

}

 

-------------------------------------------------------------
abstrace can have both abstract and concrete method.
Interface can have only abstract method,
A class can implement multiple interfaces.
A class can only extend single abstract class.
-------------------------------------------------------------
