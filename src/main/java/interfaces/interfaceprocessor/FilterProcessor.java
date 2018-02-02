//: interfaces/interfaceprocessor/FilterProcessor.java
package interfaces.interfaceprocessor;

import interfaces.filters.*;
//第二种复用代码的方式,使用适配器模式.这种情况发生在如 某些类库是用来使用的(不能对原始代码进行修改)
//适配中的代码将接受你所拥有的接口,并产生你所需要的接口
//这个类也用到 代理模式
class FilterAdapter implements Processor
{
    //需要适配的对象(或者说是需要适配的接口),原始类
    Filter filter;
    //传入  需要适配的对象
    public FilterAdapter(Filter filter)
    {
        this.filter = filter;
    }
    //适配后的接口(适配后的接口中的方法)
    public String name()
    {
        return filter.name();
    }
    //(适配后)接口中的方法,返回值更具体了
    public Waveform process(Object input)
    {//调用原始类中的方法(适配前类中的方法)
        return filter.process((Waveform) input);
    }
}

public class FilterProcessor
{
    public static void main(String[] args)
    {
        Waveform w = new Waveform();
        //这时候就可以调用 原先 只 接收Process类型参数的方法
        Apply.process(new FilterAdapter(new LowPass(1.0)), w);
        Apply.process(new FilterAdapter(new HighPass(2.0)), w);
        Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);
    }
} /* Output:
  Using Processor LowPass
  Waveform 0
  Using Processor HighPass
  Waveform 0
  Using Processor BandPass
  Waveform 0
  *///:~
