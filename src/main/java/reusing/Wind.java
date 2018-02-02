package reusing;

//: reusing/Wind.java
// Inheritance & upcasting.
//乐器类
class Instrument
{
    public void play()
    {
    }
    //静态方法无法被子类重写.可以理解为静态方法只属于当前类
    static void tune(Instrument i)
    {
        // ...
        i.play();
    }
    
    void hehe(){
        
    }
}
//Wind乐器类
// Wind objects are instruments
// because they have the same interface:
public class Wind extends Instrument
{
    public static void main(String[] args)
    {
        Wind flute = new Wind();
        //Wind类是Instrument类的子类.tune方法接收一个Instrument类型的参数,此时flute对象 向上转型 为Instrument类型
        Instrument.tune(flute); // Upcasting
    }
    
    @Override
    void hehe()
    {
        // TODO Auto-generated method stub
        super.hehe();
    }
} ///:~
