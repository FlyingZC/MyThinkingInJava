package generics;
//: generics/GenericArray.java

public class GenericArray<T>
{
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int sz)
    {
        //不能new T[sz],所以new Object[sz]再转型
        array = (T[]) new Object[sz];
    }

    public void put(int index, T item)
    {
        array[index] = item;
    }

    public T get(int index)
    {
        return array[index];
    }

    // Method that exposes the underlying representation:
    //该方法返回T[]类型数组
    public T[] rep()
    {
        return array;
    }

    public static void main(String[] args)
    {
        GenericArray<Integer> gai = new GenericArray<Integer>(10);
        // This causes a ClassCastException:
        //! Integer[] ia = gai.rep();
        // This is OK:
        Object[] oa = gai.rep();
    }
} ///:~
