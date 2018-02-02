package holding;

// Simple container example (produces compiler warnings).
// {ThrowsException}
import java.util.*;

class Apple
{
    private static long counter;

    private final long id = counter++;

    public long id()
    {
        return id;
    }
}

class Orange
{
}

public class ApplesAndOrangesWithoutGenerics
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        //不使用泛型,此时ArrayList可放入任何Object
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++)
            apples.add(new Apple());//放入Apple类型对象
        // Not prevented from adding an Orange to apples:
        apples.add(new Orange());//放入Orange类型对象,可以放入,不报错
        for (int i = 0; i < apples.size(); i++)
            ((Apple) apples.get(i)).id();//运行期,当强转成Apple类型时,在取Orange类型对象时报错java.lang.ClassCastException
        // Orange is detected only at run time
    }
} /* (Execute to see output) *///:~
