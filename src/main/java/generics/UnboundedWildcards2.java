package generics;

//: generics/UnboundedWildcards2.java
import java.util.*;

public class UnboundedWildcards2
{
    static Map map1;

    static Map<?, ?> map2;

    static Map<String, ?> map3;

    static void assign1(Map map)
    {
        map1 = map;
    }

    static void assign2(Map<?, ?> map)
    {
        map2 = map;
    }

    static void assign3(Map<String, ?> map)
    {
        map3 = map;
    }

    public static void main(String[] args)
    {
        assign1(new HashMap());
        //assign2方法接收的是含有两个无边界通配符的Map参数,即Map<?,?>,此时和不写泛型相同.
        assign2(new HashMap());
        
        // Unchecked conversion. Found: HashMap  Required: Map<String,?>
        //但是若真有一个无边界通配符,就会提供编译期警告
        assign3(new HashMap()); // Warning:
        
        assign1(new HashMap<String, Integer>());
        assign2(new HashMap<String, Integer>());
        assign3(new HashMap<String, Integer>());
    }
} ///:~
