//: polymorphism/music/Wind.java
package polymorphism.music;

// Wind objects are instruments
// because they have the same interface:
//乐器的一种
public class Wind extends Instrument
{
    // Redefine interface method:
    @Override
    public void play(Note n)
    {
        System.out.println("Wind.play() " + n);
    }
} ///:~
