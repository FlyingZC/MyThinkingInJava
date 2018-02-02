//: polymorphism/music/Music.java
// Inheritance & upcasting.
package polymorphism.music;
//音乐类
public class Music
{
    public static void tune(Instrument i)
    {
        // ...
        i.play(Note.MIDDLE_C);//3.乐器play乐符
    }

    public static void main(String[] args)
    {
        Wind flute = new Wind();//1.创建一个wind乐器
        tune(flute); // Upcasting//2.曲调(乐器)
    }
} /* Output:
  Wind.play() MIDDLE_C
  *///:~
