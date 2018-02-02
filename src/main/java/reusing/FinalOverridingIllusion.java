package reusing;

//: reusing/FinalOverridingIllusion.java
// It only looks like you can override
// a private or private final method.
import static net.mindview.util.Print.*;

class WithFinals
{
    // Identical to "private" alone:
    private final void f()
    {
        print("WithFinals.f()");
    }
    //private方法默认隐含 使用final修饰
    // Also automatically "final":
    private void g()
    {
        print("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals
{
    private final void f()
    {
        print("OverridingPrivate.f()");
    }

    private void g()
    {
        print("OverridingPrivate.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate
{
    public final void f()
    {
        print("OverridingPrivate2.f()");
    }

    public void g()
    {
        print("OverridingPrivate2.g()");
    }
}

public class FinalOverridingIllusion
{
    public static void main(String[] args)
    {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // You can upcast:向上转型
        OverridingPrivate op = op2;
        // But you can't call the methods:但不能调用父类中同名的private方法,编译期报错
        //! op.f();
        //! op.g();
        // Same here:
        WithFinals wf = op2;
        //! wf.f();
        //! wf.g();
    }
} /* Output:
  OverridingPrivate2.f()
  OverridingPrivate2.g()
  *///:~
