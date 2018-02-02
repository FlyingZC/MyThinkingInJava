//: innerclasses/Callbacks.java
//匿名函数 模拟 闭包 回调
// Using inner classes for callbacks
package innerclasses;

import static net.mindview.util.Print.*;
//1.Incrementable接口,内有increment()方法
interface Incrementable
{
    void increment();
}

//2.一种简单实现接口的方式
// Very simple to just implement the interface:
class Callee1 implements Incrementable
{
    private int i = 0;

    public void increment()
    {
        i++;
        print(i);
    }
}
//3.一个类,包含了和Incrementable接口同名的increment()fANGF
class MyIncrement
{
    public void increment()
    {
        print("Other operation");
    }

    static void f(MyIncrement mi)
    {
        mi.increment();
    }
}

//4.Call2这个类已经继承MyIncrement类并重写了increment()方法,无法再实现Incrementable接口并实现其中的increment()方法
// If your class must implement increment() in
// some other way, you must use an inner class:
class Callee2 extends MyIncrement
{
    private int i = 0;
    @Override
    public void increment()
    {
        super.increment();
        i++;
        print(i);
    }
    //5.使用内部类 实现Incrementable接口并实现increment()方法
    private class Closure implements Incrementable
    {   //5.实现接口中的increment()方法,该方法 返回外部类中的increment()方法
        public void increment()
        {
            // Specify outer-class method, otherwise
            // you'd get an infinite recursion:
            Callee2.this.increment();//调用外部类中的increment()方法
        }
    }
    //6.一个返回内部类对象的钩子 的方法
    Incrementable getCallbackReference()
    {
        return new Closure();
    }
}
//7.调用类,用于调用以上的类
class Caller
{
    private Incrementable callbackReference;

    Caller(Incrementable cbh)
    {
        callbackReference = cbh;
    }

    void go()
    {
        callbackReference.increment();
    }
}

public class Callbacks
{
    public static void main(String[] args)
    {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        //8.该类构造方法接收一个Incrementable参数
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
} /* Output:
  Other operation
  1
  1
  2
  Other operation
  2
  Other operation
  3
  *///:~
