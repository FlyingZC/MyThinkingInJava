package holding;

//: holding/SimpleCollection.java
import java.util.*;

public class SimpleCollection
{
    public static void main(String[] args)
    {
        Collection<Integer> c = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            c.add(i); // Autoboxing 自动装箱
        for (Integer i : c)
            System.out.print(i + ", ");
        
        for(int i:c)//自动拆箱
            System.out.println(i);
    }
} /* Output:
  0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
  *///:~
