//: enumerated/cartoons/EnumImplementation.java
// An enum can implement an interface
package enumerated.cartoons;

import java.util.*;
import net.mindview.util.*;
//枚举类 已经默认继承自java.lang.Enum类.所以不能再继承自其它类.只能实现其他接口
enum CartoonCharacter implements Generator<CartoonCharacter>
{
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private Random rand = new Random(47);

    public CartoonCharacter next()
    {
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation
{
    public static <T> void printNext(Generator<T> rg)
    {
        System.out.print(rg.next() + ", ");
    }

    public static void main(String[] args)
    {
        // Choose any instance:
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++)
            printNext(cc);
    }
} /* Output:
  BOB, PUNCHY, BOB, SPANKY, NUTTY, PUNCHY, SLAPPY, NUTTY, NUTTY, SLAPPY,
  *///:~
