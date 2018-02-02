package reusing;

//: reusing/Orc.java
// The protected keyword.
import static net.mindview.util.Print.*;
//反派类
class Villain
{
    //1.私有域
    private String name;
    //2.通过protected方法允许子类修改该属性
    protected void set(String nm)
    {
        name = nm;
    }

    public Villain(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return "I'm a Villain and my name is " + name;
    }
}
//妖魔类
public class Orc extends Villain
{
    private int orcNumber;

    public Orc(String name, int orcNumber)
    {
        super(name);
        this.orcNumber = orcNumber;
    }

    public void change(String name, int orcNumber)
    {
        set(name); // Available because it's protected
        this.orcNumber = orcNumber;
    }

    public String toString()
    {
        return "Orc " + orcNumber + ": " + super.toString();
    }

    public static void main(String[] args)
    {
        Orc orc = new Orc("Limburger", 12);
        print(orc);
        orc.change("Bob", 19);
        print(orc);
    }
} /* Output:
  Orc 12: I'm a Villain and my name is Limburger
  Orc 19: I'm a Villain and my name is Bob
  *///:~
