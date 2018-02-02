package polymorphism;

//: polymorphism/StaticPolymorphism.java
// Static methods are not polymorphic.

class StaticSuper
{
    public static String staticGet()
    {
        return "Base staticGet()";
    }

    public String dynamicGet()
    {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper
{
    public static String staticGet()
    {
        return "Derived staticGet()";
    }

    public String dynamicGet()
    {
        return "Derived dynamicGet()";
    }
}

public class StaticPolymorphism
{
    public static void main(String[] args)
    {
        StaticSuper sup = new StaticSub(); // Upcast
        System.out.println(sup.staticGet());//静态方法是属于类的,sup引用,直接掉父类的static方法
        System.out.println(sup.dynamicGet());
    }
} /* Output:
  Base staticGet()
  Derived dynamicGet()
  *///:~
