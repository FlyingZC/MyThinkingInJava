//: enumerated/Burrito.java
package enumerated;
//使用静态导入enum类
import static enumerated.Spiciness.*;

public class Burrito
{
    Spiciness degree;

    public Burrito(Spiciness degree)
    {
        this.degree = degree;
    }

    public String toString()
    {
        return "Burrito is " + degree;
    }

    public static void main(String[] args)
    {
        //则可以直接使用enum实例
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }
} /* Output:
  Burrito is NOT
  Burrito is MEDIUM
  Burrito is HOT
  *///:~
