package holding;


//: holding/ApplesAndOrangesWithGenerics.java
import java.util.*;

/**
 * @author Flyin
 * 使用泛型 的集合
 * 可以在编译期 防止将错误类型对象放置到容器中
 * 且在取出具有泛型的元素时,类型转换 也不是必须的,因为List知道它保存的是什么类型,会在调用get()时 替你执行转型(添加转型代码)
 */
public class ApplesAndOrangesWithGenerics
{
    public static void main(String[] args)
    {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for (int i = 0; i < 3; i++)
            apples.add(new Apple());
        // Compile-time error:编译期报错
        // apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++)
            System.out.println(apples.get(i).id());
        // Using foreach:
        for (Apple c : apples)
            System.out.println(c.id());
    }
} /* Output:
  0
  1
  2
  0
  1
  2
  *///:~
