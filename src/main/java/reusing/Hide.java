package reusing;

//: reusing/Hide.java
// Overloading a base-class method name in a derived
// class does not hide the base-class versions.
import static net.mindview.util.Print.*;

class Homer
{
    char doh(char c)
    {
        print("doh(char)");
        return 'd';
    }

    float doh(float f)
    {
        print("doh(float)");
        return 1.0f;
    }
}

class Milhouse
{
}

class Bart extends Homer
{
    //该方法由于和父类中的同名方法参数列表不同,可以理解为重载.并不是重写(重写方法名相同,)
    void doh(Milhouse m)
    {
        print("doh(Milhouse)");
    }
}

public class Hide
{
    public static void main(String[] args)
    {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
} /* Output:
  doh(float)
  doh(char)
  doh(float)
  doh(Milhouse)
  *///:~
