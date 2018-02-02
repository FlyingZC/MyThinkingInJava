package reusing;

//: reusing/Beetle.java
// The full process of initialization.
import static net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.List;

class Insect
{
    private int i = 9;

    protected int j;

    Insect()
    {
        print("父类中的成员变量i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 = printInit("父类中static成员变量x1初始化.static Insect.x1 initialized");

    static int printInit(String s)
    {
        print(s);
        return 47;
    }
}

public class Beetle extends Insect
{
    private int num;
    private String str;
    private List<String> list=new ArrayList<String>();
    
    private int k = printInit("子类中成员变量k初始化-Beetle.k initialized");

    public Beetle()
    {
        print("子类中k = " + k);
        print("子类中j = " + j);
    }

    private static int x2 = printInit("子类中static成员变量x2初始化-static Beetle.x2 initialized");

    public static void main(String[] args)
    {
        print("Beetle constructor");
        Beetle b = new Beetle();
    }
} /* Output:
  static Insect.x1 initialized
  static Beetle.x2 initialized
  Beetle constructor
  i = 9, j = 0
  Beetle.k initialized
  k = 47
  j = 39
  *///:~
