package generics;
//: generics/CreatorGeneric.java

abstract class GenericWithCreate<T>
{
    final T element;
    //构造方法
    GenericWithCreate()
    {
        element = create();
    }
    //把创建 对象的方法留给子类实现
    abstract T create();
}

class MyObj
{
}

//实现类
class Creator extends GenericWithCreate<MyObj>
{
    MyObj create()
    {
        return new MyObj();
    }

    void f()
    {
        System.out.println(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric
{
    public static void main(String[] args)
    {
        Creator c = new Creator();
        c.f();
    }
} /* Output:
  X
  *///:~
