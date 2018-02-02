package generics;
//: generics/FactoryConstraint.java
//01:定义 工厂类
interface IFactory<T>
{
    T create();
}

class Foo2<T>
{
    private T x;
    /**
     * 该构造方法  声明一个继承自IFactory类的F泛型类型,当然恰巧IFactory<T>本身是个泛型类
     * 该构造方法 接收 一个工厂类
     * 该构造方法 给x对象赋值
     * @param factory
     */
    public <F extends IFactory<T>> Foo2(F factory)
    {
        x = factory.create();
    }
    // ...
}
//03:用于创建Integer类的工厂类
class IntegerFactory implements IFactory<Integer>
{
    public Integer create()
    {
        return new Integer(0);
    }
}

class Widget
{
    //02:实现具体类型的工厂类
    public static class Factory implements IFactory<Widget>
    {
        public Widget create()
        {
            return new Widget();
        }
    }
}

public class FactoryConstraint
{
    public static void main(String[] args)
    {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
} ///:~
