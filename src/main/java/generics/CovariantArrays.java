package generics;

import java.util.ArrayList;
import java.util.List;

//: generics/CovariantArrays.java

class Fruit
{
}

class Orange extends Fruit
{
}

class Apple extends Fruit
{
}

class Jonathan extends Apple
{
}


public class CovariantArrays
{
    public static void main(String[] args)
    {
        List<Fruit> list = new ArrayList<Fruit>();
        list.add(new Apple());
        
        //注意 虽然声明的类型是Fruit[]类型,实际存储的是Apple[]类型
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple(); // OK
        //Jonathan是Apple的子类
        fruit[1] = new Jonathan(); // OK
        // Runtime type is Apple[], not Fruit[] or Orange[]:
        try
        {
            // Compiler allows you to add Fruit:
            //编译器允许 添加Fruit()类型,但是运行期报错
            fruit[0] = new Fruit(); // ArrayStoreException
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        try
        {
            // Compiler allows you to add Oranges:
            fruit[0] = new Orange(); // ArrayStoreException
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
} /* Output:
  java.lang.ArrayStoreException: Fruit
  java.lang.ArrayStoreException: Orange
  *///:~
