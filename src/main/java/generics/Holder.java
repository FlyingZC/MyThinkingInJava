package generics;
//: generics/Holder.java

public class Holder<T>
{
    private T value;

    public Holder()
    {
    }

    public Holder(T val)
    {
        value = val;
    }

    public void set(T val)
    {
        value = val;
    }
    
    public void setObj(Object val)
    {
        value = (T) val;
    }

    public T get()
    {
        return value;
    }

    public boolean equals(Object obj)
    {
        return value.equals(obj);
    }

    public static void main(String[] args)
    {
        Holder<Apple> appleHolder = new Holder<Apple>(new Apple());
        Apple d = appleHolder.get();
        appleHolder.set(d);
        
        //泛型是不变的,不能将Holder<Apple>类型的对象 转型成Holder<Fruit>类型的对象
        //Type mismatch: cannot convert from Holder<Apple> to Holder<Fruit>
        Holder<Fruit> Fruit = appleHolder; // Cannot upcast
        
        //但是可以使用通配符 将Holder<Apple>类型的对象 转型成Holder<? extends Fruit>类型的对象
        Holder<? extends Fruit> fruitHolder = appleHolder; // OK
        
        //但是在给定了<? extends Fruit>这个边界后,此时get出来的是Fruit类型.而不管具体的Holder<Apple>类型
        Fruit p = fruitHolder.get();
        //若要获取具体的类型,可以转型 不会由编译期警告
        d = (Apple) fruitHolder.get(); // Returns 'Fruit'类型
        try
        {
            //但是强转存在着ClassCastException的风险,编译期不报错,运行时转型异常
            Orange c = (Orange) fruitHolder.get(); // No warning
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        //fruitHolder的泛型参数是<? extends Fruit>.即代表任何事物,而编译期无法验证"任何事物"的类型安全
        fruitHolder.set(new Apple()); // Cannot call set()
        fruitHolder.set(new Fruit()); // Cannot call set()
        
        //setObj方法接收的是Object类型
        fruitHolder.setObj(new Apple());
        fruitHolder.setObj(new Fruit());
        fruitHolder.setObj(new Object());
        
        //但是equals()方法工作良好,因为它接受Object类型参数 而不是 T类型参数.因此编译器只关注该方法传递进啦的和要返回的对象类型
        System.out.println(fruitHolder.equals(d)); // OK
    }
} /* Output: (Sample)
  java.lang.ClassCastException: Apple cannot be cast to Orange
  true
  *///:~
