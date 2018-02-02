package polymorphism;

//: polymorphism/Transmogrify.java
// Dynamically changing the behavior of an object
// via composition (the "State" design pattern).
import static net.mindview.util.Print.*;

class Actor
{
    public void act()
    {
    }
}

class HappyActor extends Actor
{
    @Override
    public void act()
    {
        print("HappyActor");
    }
}

class SadActor extends Actor
{
    @Override
    public void act()
    {
        print("SadActor");
    }
}

class Stage
{
    //1.Stage对象包含一个对Actor的引用,并初始化为HappyActor对象
    private Actor actor = new HappyActor();

    public void change()
    {//2.
        actor = new SadActor();
    }

    public void performPlay()
    {
        actor.act();
    }
}

public class Transmogrify
{
    public static void main(String[] args)
    {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
} /* Output:
  HappyActor
  SadActor
  *///:~
