package typeinfo;

//: typeinfo/ClassInitialization.java
import java.util.*;

class Initable
{
    static final int staticFinal = 47;

    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static
    {
        System.out.println("Initializing Initable");
    }
}

class Initable2
{
    static int staticNonFinal = 147;
    static
    {
        System.out.println("Initializing Initable2");
    }
}

class Initable3
{
    static int staticNonFinal = 74;
    static
    {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization
{
    public static Random rand = new Random(47);

    public static void main(String[] args) throws Exception
    {   //1.使用.class语法来获得对该类Class对象引用时,不会触发类的初始化
        Class<Initable> initable = Initable.class;
        System.out.println("After creating Initable ref");
        
        // Does not trigger initialization: 
        //staticFinal是用static final修饰的编译期常量,不需要加载对该类进行初始化即可访问该对象(即不会初始化静态块)
        System.out.println(Initable.staticFinal);
        
        // Does trigger initialization:
        //staticFinal2虽然也是使用 static final修饰的,但是其是个随机数,需要确定,会触发类的初始化
        System.out.println(Initable.staticFinal2);
        
        // Does trigger initialization: 
        //仅仅使用static修饰,会触发初始化
        System.out.println(Initable2.staticNonFinal);
        
        //使用Class.forName一定会立即初始化该类
        Class initable3 = Class.forName("typeinfo.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
} /* Output:
  After creating Initable ref
  47
  Initializing Initable
  258
  Initializing Initable2
  147
  Initializing Initable3
  After creating Initable3 ref
  74
  *///:~
