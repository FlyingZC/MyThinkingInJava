package innerclasses;

//: innerclasses/Parcel5.java
// Nesting a class within a method.

public class Parcel5
{
    public Destination destination(String s)
    {//定义在方法内的内部类
        class PDestination implements Destination
        {
            private String label;

            private PDestination(String whereTo)
            {
                label = whereTo;
            }

            public String readLabel()
            {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args)
    {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
    }
} ///:~
