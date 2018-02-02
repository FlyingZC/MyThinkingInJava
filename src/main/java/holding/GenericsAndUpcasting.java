package holding;


//: holding/GenericsAndUpcasting.java
import java.util.*;

class GrannySmith extends Apple
{
}

class Gala extends Apple
{
}

class Fuji extends Apple
{
}

class Braeburn extends Apple
{
}

/**
 * @author Flyin
 * 向上转型 也可以作用于泛型
 */
public class GenericsAndUpcasting
{
    public static void main(String[] args)
    {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        apples.add(new GrannySmith());
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());
        for (Apple c : apples)
            System.out.println(c);
    }
} /* Output: (Sample)
  GrannySmith@7d772e
  Gala@11b86e7
  Fuji@35ce36
  Braeburn@757aef
  *///:~
