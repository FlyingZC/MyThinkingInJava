//: polymorphism/PrivateOverride.java
// Trying to override a private method.
package polymorphism;

import static net.mindview.util.Print.*;
//父类
public class PrivateOverride
{//父类中的private方法
    private void f()
    {
        print("private f()");
    }

    public static void main(String[] args)
    {   //父引用,子对象
        PrivateOverride po = new Derived();
        po.f();//不会发生多态现象,只会调用父类中的方法
    }
}

class Derived extends PrivateOverride
{//子类中与父类中同名的方法
    public void f()
    {
        print("public f()");
    }
} /* Output:
  private f()
  *///:~
