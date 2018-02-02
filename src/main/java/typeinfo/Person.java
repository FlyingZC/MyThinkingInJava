package typeinfo;

//: typeinfo/Person.java
// A class with a Null Object.
import net.mindview.util.*;

class Person
{
    public final String first;

    public final String last;

    public final String address;

    // etc.
    public Person(String first, String last, String address)
    {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public String toString()
    {
        return "Person: " + first + " " + last + " " + address;
    }

    public static class NullPerson extends Person implements Null
    {
        private NullPerson()
        {
            super("None", "None", "None");
        }

        public String toString()
        {
            return "NullPerson";
        }
    }
    //外部类Person有一个Null属性,指向静态内部类NullPerson,代表没有空对象
    public static final Person NULL = new NullPerson();
} ///:~
