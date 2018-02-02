package interfaces;

//: interfaces/HorrorShow.java
// Extending an interface with inheritance.

/**
 *  巨人
 */
interface Monster
{
    //恐吓
    void menace();
}

interface DangerousMonster extends Monster
{
    void destroy();
}

/**
 * 致命的  
 */
interface Lethal
{
    void kill();
}

class DragonZilla implements DangerousMonster
{
    public void menace()
    {
    }

    public void destroy()
    {
    }
}

/**
 *  吸血鬼
 */
interface Vampire extends DangerousMonster, Lethal
{
    void drinkBlood();
}

class VeryBadVampire implements Vampire
{
    public void menace()
    {
    }

    public void destroy()
    {
    }

    public void kill()
    {
    }

    public void drinkBlood()
    {
    }
}

public class HorrorShow
{
    static void u(Monster b)
    {
        b.menace();
    }

    static void v(DangerousMonster d)
    {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l)
    {
        l.kill();
    }

    public static void main(String[] args)
    {
        DangerousMonster barney = new DragonZilla();
        //barney对象自动向上转型 为 不同的接口 类型
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
} ///:~
