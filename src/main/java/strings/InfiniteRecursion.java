package strings;

//: strings/InfiniteRecursion.java
// Accidental recursion.
// {RunByHand}
import java.util.*;

public class InfiniteRecursion
{
    @Override
    public String toString()
    {   // 这里this需要调用InfiniteRecursion类的toString()方法,转成字符串输出.等于又递归调用了 本 toString()方法...
        // 字符串拼接 this,会调用 this.toString(),造成 java.lang.StackOverflowError
        // java.lang.StackOverflowError
        return " InfiniteRecursion address: " + this + "\n";
        // return super.toString();
    }

    public static void main(String[] args)
    {
        List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
        for (int i = 0; i < 10; i++) {
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
    }
} ///:~
