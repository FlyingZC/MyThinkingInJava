package exceptions;

//: exceptions/StormyInning.java
// Overridden methods may throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions.

class BaseballException extends Exception
{
}

class FoulException extends BaseballException
{
}

class StrikeException extends BaseballException
{
}

abstract class Inning
{
    public Inning() throws BaseballException
    {
    }

    public void event() throws BaseballException
    {
        // Doesn't actually have to throw anything
    }

    public abstract void atBat() throws StrikeException, FoulException;

    public void walk()
    {
    } // Throws no checked exceptions
}

class StormException extends Exception
{
}

class RainedOutException extends StormException
{
}

class PopFoulException extends FoulException
{
}

interface Storm
{
    public void event() throws RainedOutException;

    public void rainHard() throws RainedOutException;
}

public class StormyInning extends Inning implements Storm
{
    // OK to add new exceptions for constructors, but you
    // must deal with the base constructor exceptions:
    //子类构造器必须声明 父类构造器的异常,因为需要调用父类的构造器.当然可自己再添加异常声明
    public StormyInning() throws RainedOutException, BaseballException
    {
    }

    public StormyInning(String s) throws FoulException, BaseballException
    {
    }

    // Regular methods must conform to base class:
    //! void walk() throws PopFoul {} //Compile error
    // Interface CANNOT add exceptions to existing
    // methods from the base class:
    //! public void event() throws RainedOut {}
    // If the method doesn't already exist in the
    // base class, the exception is OK:
    public void rainHard() throws RainedOutException
    {
    }

    // You can choose to not throw any exceptions,
    // even if the base version does:
    public void event()
    {
    }

    // Overridden methods can throw inherited exceptions:
    //覆盖的方法 可以声明更具体的异常
    public void atBat() throws PopFoulException
    {
    }

    public static void main(String[] args)
    {
        try
        {
            StormyInning si = new StormyInning();
            si.atBat();
        }
        catch (PopFoulException e)
        {
            System.out.println("Pop foul");
        }
        catch (RainedOutException e)
        {
            System.out.println("Rained out");
        }
        catch (BaseballException e)
        {
            System.out.println("Generic baseball exception");
        }
        // Strike not thrown in derived version.
        try
        {
            // What happens if you upcast?
            Inning i = new StormyInning();
            i.atBat();
            // You must catch the exceptions from the
            // base-class version of the method:
        }
        catch (StrikeException e)
        {
            System.out.println("Strike");
        }
        catch (FoulException e)
        {
            System.out.println("Foul");
        }
        catch (RainedOutException e)
        {
            System.out.println("Rained out");
        }
        catch (BaseballException e)
        {
            System.out.println("Generic baseball exception");
        }
    }
} ///:~
