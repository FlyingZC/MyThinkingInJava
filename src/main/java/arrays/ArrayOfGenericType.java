package arrays;

import net.mindview.atunit.Test;

//: arrays/ArrayOfGenericType.java

// Arrays of generic types won't compile.

public class ArrayOfGenericType<T>
{
    T[] array; // OK

    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size)
    {
        //! array = new T[size]; // Illegal
        array = (T[]) new Object[size]; // "unchecked" Warning
    }
    // Illegal:
    //! public <U> U[] makeArray() { return new U[10]; }
    
    @Test
    public void test()
    {
        Integer[] arr = new ArrayOfGenericType<Integer>(10).array;
        arr[0] = new Integer(1);
    }
} ///:~
