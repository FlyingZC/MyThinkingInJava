package generics;

//: generics/GenericsAndCovariance.java
import java.util.*;

public class GenericsAndCovariance
{
    public static void main(String[] args)
    {
        // Wildcards allow covariance:
        //fruitList类型是List<? extends Fruit>,即具有任何从Fruit继承的类型的列表
        //但并不意味着List将持有任何类型的Fruit,
        List<? extends Fruit> fruitList = new ArrayList<Apple>();
        // Compile Error: can't add any type of object:
        //设置Apple类型的对象也不能放入,一旦声明成上述这样,任何对象都不能放入了
        fruitList.add(new Apple());
        fruitList.add(new Fruit());
        fruitList.add(new Object());
        fruitList.add(null); // Legal but uninteresting
        // We know that it returns at least Fruit:
        //但是可以调用一个返回Fruit的方法,是安全的,因为List中任何对象至少具有Fruit或更具体的类型
        Fruit f = fruitList.get(0);
    }
} ///:~







