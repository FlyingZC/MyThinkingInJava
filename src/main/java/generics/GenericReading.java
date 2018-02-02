package generics;

//: generics/GenericReading.java
import java.util.*;

public class GenericReading
{
    static <T> T readExact(List<T> list)
    {
        return list.get(0);
    }

    static List<Apple> apples = Arrays.asList(new Apple());

    static List<Fruit> fruits = Arrays.asList(new Fruit());

    // A static method adapts to each call:
    static void f1()
    {
        Apple a = readExact(apples);
        Fruit f = readExact(fruits);
        f = readExact(apples);
    }

    // If, however, you have a class, then its type is
    // established when the class is instantiated:
    static class Reader<T>
    {
        T readExact(List<T> list)
        {
            return list.get(0);
        }
    }

    static void f2()
    {
        Reader<Fruit> fruitReader = new Reader<Fruit>();
        Fruit f = fruitReader.readExact(fruits);
        Fruit a = fruitReader.readExact(apples); // Error:正常来说,不能从List<Apple>中读出Fruit对象
        //readExact(List<Fruit>) cannot be applied to (List<Apple>).
    }

    static class CovariantReader<T>
    {
        T readCovariant(List<? extends T> list)
        {
            return list.get(0);
        }
    }

    static void f3()
    {
        CovariantReader<Fruit> fruitReader = new CovariantReader<Fruit>();
        Fruit f = fruitReader.readCovariant(fruits);
        Fruit a = fruitReader.readCovariant(apples);//可以从List<Apple>中读出Fruit类型
    }

    public static void main(String[] args)
    {
        f1();
        f2();
        f3();
    }
} ///:~
