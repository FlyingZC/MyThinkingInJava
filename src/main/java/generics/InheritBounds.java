package generics;
//: generics/InheritBounds.java

class HoldItem<T>
{
    T item;

    HoldItem(T item)
    {
        this.item = item;
    }

    T getItem()
    {
        return item;
    }
}

//上届为HasColor类
class Colored2<T extends HasColor> extends HoldItem<T>
{
    Colored2(T item)
    {
        super(item);
    }

    //T item对象在父类HolderItem中定义.由于 上届为HasColor类型,此时可使用HasColor中的方法
    java.awt.Color color()
    {
        return item.getColor();
    }
}

class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T>
{
    ColoredDimension2(T item)
    {
        super(item);
    }

    int getX()
    {
        return item.x;
    }

    int getY()
    {
        return item.y;
    }

    int getZ()
    {
        return item.z;
    }
}

class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T>
{
    Solid2(T item)
    {
        super(item);
    }

    int weight()
    {
        return item.weight();
    }
}

public class InheritBounds
{
    public static void main(String[] args)
    {
        Solid2<Bounded> solid2 = new Solid2<Bounded>(new Bounded());
        solid2.color();
        solid2.getY();
        solid2.weight();
    }
} ///:~
