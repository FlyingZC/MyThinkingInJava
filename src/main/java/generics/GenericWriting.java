package generics;

//: generics/GenericWriting.java
import java.util.*;

public class GenericWriting
{
    //该方法 使用确切的泛型参数
    static <T> void writeExact(List<T> list, T item)
    {
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<Apple>();

    static List<Fruit> fruit = new ArrayList<Fruit>();

    static void f1()
    {
        writeExact(apples, new Apple());
        // Error:Incompatible types: found Fruit, required Apple
        writeExact(fruit, new Apple()); 
    }

    static <T> void writeWithWildcard(List<? super T> list, T item)
    {
        list.add(item);
    }

    static void f2()
    {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
    }

    public static void main(String[] args)
    {
        f1();
        f2();
    }
} ///:~
