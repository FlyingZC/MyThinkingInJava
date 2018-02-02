//: net/mindview/util/TwoTuple.java
package net.mindview.util;

/**
 * 该类的对象 用于 存储两个不同类型的对象
 * @author Flyin
 *
 * @param <A>
 * @param <B>
 */
public class TwoTuple<A, B>
{
    public final A first;

    public final B second;

    public TwoTuple(A a, B b)
    {
        first = a;
        second = b;
    }

    public String toString()
    {
        return "(" + first + ", " + second + ")";
    }

} ///:~
