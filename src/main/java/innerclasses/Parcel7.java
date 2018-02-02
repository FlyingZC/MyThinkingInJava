package innerclasses;

//: innerclasses/Parcel7.java
// Returning an instance of an anonymous inner class.

public class Parcel7
{
    public Contents contents()
    {//匿名内部类.即:创建一个 继承自 Contents的匿名内部类的对象.通过new Contents(){}表达式返回的引用 被自动向上转型为对Contents的引用
        return new Contents()
        { // Insert a class definition
            private int i = 11;

            public int value()
            {
                return i;
            }
        }; // Semicolon required in this case
    }

    public static void main(String[] args)
    {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }
} ///:~
