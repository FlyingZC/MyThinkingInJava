package generics;
//: generics/Erased.java

// {CompileTimeError} (Won't compile)

public class Erased<T>
{
    private final int SIZE = 100;

    public void f(Object arg)
    {
        //annot perform instanceof check against type parameter T. 
        //Use its erasure Object instead since further generic type information will be erased at runtime
        //if (arg instanceof T)
        {
        }

        //Cannot instantiate the type T
        //T var = new T(); // Error

        //Cannot create a generic array of T
        //T[] array = new T[SIZE]; // Error

        //Type safety: Unchecked cast from Object[] to T[]
        T[] array2 = (T[]) new Object[SIZE];
    }

} ///:~
