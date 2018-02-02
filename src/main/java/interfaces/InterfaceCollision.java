//: interfaces/InterfaceCollision.java
package interfaces;
//三个接口中定义了 方法名相同的三个方法
interface I1
{
    void f();
}

interface I2
{
    int f(int i);
}

interface I3
{
    int f();
}

class C
{
    public int f()
    {
        return 1;
    }
}

//可删除 里面的方法 ,看eclipse会生成什么方法
class C2 implements I1, I2
{
    public void f()
    {
    }

    public int f(int i)
    {
        return 1;
    } // overloaded
}

class C3 extends C implements I2
{
    public int f(int i)
    {
        return 1;
    } // overloaded
}

class C4 extends C implements I3
{
    // Identical, no problem:
    public int f()
    {
        return 1;
    }
}

// Methods differ only by return type:
//! class C5 extends C implements I1 {}
//! interface I4 extends I1, I3 {} ///:~
