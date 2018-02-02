package generics;

//: generics/SuperTypeWildcards.java
import java.util.*;

public class SuperTypeWildcards
{
    //设想以下如果此处是List<? extends Apple>即代表能放入的是Apple或某个子类型(但是总得确定到底是哪个类型吧)
    //那编译器就无法判断到底是哪个类型,所以所有类型数据都放不进去
    //但是若是List<? super Apple>则代表它至少是Apple类型,放入Apple及其子类型是没问题的
    static void writeTo(List<? super Apple> apples)
    {
        apples.add(new Apple());
        //Apple的子类
        apples.add(new Jonathan());
        apples.add(new Fruit()); // Error
    }
    
    static void writeTo2(List<Apple> list)
    {
        list.add(new Apple());
        list.add(new Jonathan());
        list.add(new Fruit());
    }
    
    static void write(List<? extends Apple> list)
    {
        list.add(null);
        list.add(new Apple());
    }
} ///:~
