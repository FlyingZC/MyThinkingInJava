package innerclasses;

//: innerclasses/Parcel2.java
// Returning a reference to an inner class.

public class Parcel2
{
    class Contents
    {
        private int i = 11;

        public int value()
        {
            return i;
        }
    }

    class Destination
    {
        private String label;

        Destination(String whereTo)
        {
            label = whereTo;
        }

        String readLabel()
        {
            return label;
        }
    }
    //该 方法 返回内部类 对象
    public Destination to(String s)
    {
        return new Destination(s);
    }

    public Contents contents()
    {
        return new Contents();
    }

    public void ship(String dest)
    {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args)
    {
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");
        Parcel2 q = new Parcel2();
        // Defining references to inner classes:
        //内部类类型:外部类.内部类
        Parcel2.Contents c = q.contents();
        Parcel2.Destination d = q.to("Borneo");
    }
} /* Output:
  Tasmania
  *///:~
