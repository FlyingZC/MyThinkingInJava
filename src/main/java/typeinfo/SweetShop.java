package typeinfo;

//: typeinfo/SweetShop.java
// Examination of the way the class loader works.
import static net.mindview.util.Print.*;

class Candy
{
    static
    {
        print("Loading Candy");
    }
}

class Gum
{
    static
    {
        print("Loading Gum");
    }
}

class Cookie
{
    static
    {
        print("Loading Cookie");
    }
}

public class SweetShop
{//debug一步步走
    public static void main(String[] args)
    {
        print("inside main");
        new Candy();
        print("After creating Candy");
        try
        {//Class.forName时 会创建Gum类的Class对象,此时会执行Gum类中的静态代码
            Class.forName("typeinfo.Gum");
            //第二次不会创建Class对象,也不会调用静态代码块
            Class.forName("typeinfo.Gum");
        }
        catch (ClassNotFoundException e)
        {
            print("Couldn't find Gum");
        }
        print("After Class.forName(\"Gum\")");
        new Cookie();
        print("After creating Cookie");
    }
} /* Output:
  inside main
  Loading Candy
  After creating Candy
  Loading Gum
  After Class.forName("Gum")
  Loading Cookie
  After creating Cookie
  *///:~
