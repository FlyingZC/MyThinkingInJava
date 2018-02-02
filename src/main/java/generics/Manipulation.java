package generics;
//: generics/Manipulation.java

// {CompileTimeError} (Won't compile)

class Manipulator<T>
{
    private T obj;

    public Manipulator(T x)
    {
        obj = x;
    }

    // Error: cannot find symbol: method f():
    public void manipulate()
    {
        //obj是T类型,点不出来方法,以下报错.即泛型擦除后,obj相当于Object类型,只能点出Object类中的方法
        //obj.f();
    }
}

public class Manipulation
{
    public static void main(String[] args)
    {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<HasF>(hf);
        manipulator.manipulate();
    }
} ///:~
