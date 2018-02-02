package polymorphism;

//: polymorphism/CovariantReturn.java

class Grain
{
    public String toString()
    {
        return "Grain";
    }
}

class Wheat extends Grain
{
    @Override
    public String toString()
    {
        return "Wheat";
    }
}

class Mill
{
    Grain process()
    {
        return new Grain();
    }
}

class WheatMill extends Mill
{
    Wheat process()
    {
        return new Wheat();
    }
}
//协变 返回
public class CovariantReturn
{
    public static void main(String[] args)
    {
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);
        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }
} /* Output:
  Grain
  Wheat
  *///:~
