package polymorphism;

//: polymorphism/ReferenceCounting.java
// Cleaning up shared member objects.
import static net.mindview.util.Print.*;
//Composing类多个实例,共享一个Shared对象.在创建Composing对象时,会在shared中的refcount+1.
//在销毁多个Composing实例时,会同时调用Shared中的dispose().该方法会每次减1个refcount.知道refcount=0则销毁Shared对象
//共享
class Shared
{
    private int refcount = 0;

    private static long counter = 0;

    private final long id = counter++;

    public Shared()
    {
        print("Creating " + this);
    }

    public void addRef()
    {
        refcount++;
    }

    protected void dispose()
    {//当引用计数为0,销毁
        if (--refcount == 0)
            print("Disposing " + this);
    }

    public String toString()
    {
        return "Shared " + id;
    }
}
//组成
class Composing
{
    private Shared shared;

    private static long counter = 0;

    private final long id = counter++;

    public Composing(Shared shared)
    {
        print("Creating " + this);
        this.shared = shared;
        this.shared.addRef();//对shared添加引用计数
    }

    protected void dispose()
    {
        print("disposing " + this);
        shared.dispose();
    }

    public String toString()
    {
        return "Composing " + id;
    }
}
//引用计数
public class ReferenceCounting
{
    public static void main(String[] args)
    {
        Shared shared = new Shared();
        Composing[] composing = {new Composing(shared), new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared)};
        for (Composing c : composing)
            c.dispose();
    }
} /* Output:
  Creating Shared 0
  Creating Composing 0
  Creating Composing 1
  Creating Composing 2
  Creating Composing 3
  Creating Composing 4
  disposing Composing 0
  disposing Composing 1
  disposing Composing 2
  disposing Composing 3
  disposing Composing 4
  Disposing Shared 0
  *///:~
