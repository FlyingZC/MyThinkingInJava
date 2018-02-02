//: innerclasses/controller/Event.java
// The common methods for any control event.
package innerclasses.controller;
//该接口 描述 要 控制的事件
public abstract class Event
{
    private long eventTime;

    protected final long delayTime;

    public Event(long delayTime)
    {
        this.delayTime = delayTime;
        start();
    }

    public void start()
    { // Allows restarting
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready()
    {
        return System.nanoTime() >= eventTime;
    }

    /** <一句话功能简述>具体要控制的事件 方法
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    public abstract void action();
} ///:~
